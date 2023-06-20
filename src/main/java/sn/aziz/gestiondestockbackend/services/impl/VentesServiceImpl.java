package sn.aziz.gestiondestockbackend.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.ArticleDto;
import sn.aziz.gestiondestockbackend.dto.MvtStkDto;
import sn.aziz.gestiondestockbackend.dto.VentesDto;
import sn.aziz.gestiondestockbackend.exceptions.EntityNotFountException;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;
import sn.aziz.gestiondestockbackend.exceptions.InvalidEntityException;
import sn.aziz.gestiondestockbackend.models.*;
import sn.aziz.gestiondestockbackend.repositories.ArticleRepository;
import sn.aziz.gestiondestockbackend.repositories.LigneVenteRepository;
import sn.aziz.gestiondestockbackend.repositories.VentesRepository;
import sn.aziz.gestiondestockbackend.services.MvtStkService;
import sn.aziz.gestiondestockbackend.services.VentesService;
import sn.aziz.gestiondestockbackend.validators.VenteValidator;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static sn.aziz.gestiondestockbackend.exceptions.Errorcodes.VENTE_NOT_VALID;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {
    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;
    private MvtStkService mvtStkService;

    public VentesServiceImpl(ArticleRepository articleRepository, VentesRepository ventesRepository, LigneVenteRepository ligneVenteRepository, MvtStkService mvtStkService) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.mvtStkService = mvtStkService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VenteValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVentesDto -> {
            Optional<Article> article = articleRepository.findById(ligneVentesDto.getArticleDto().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVentesDto.getArticleDto().getId() + " n'a ete trouve dans la BDD");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", VENTE_NOT_VALID, errors);
        }

        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = ligneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVentes(savedVentes);
            ligneVenteRepository.save(ligneVente);
            updateMvtStk(ligneVente);
        });

        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(()->new EntityNotFountException("Aucune vente n'a ete trouve dans la BDD", Errorcodes.VENTE_NOT_FOND));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFountException(
                        "Aucune vente client n'a ete trouve avec le CODE " + code, VENTE_NOT_VALID));
    }


    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByVentes(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidEntityException("Impossible de supprimer une vente .....",
                   Errorcodes.VENTE_ALREADY_IN_USE);
        }
        ventesRepository.deleteById(id);
    }

    private void updateMvtStk(LigneVente lig) {
        MvtStkDto mvtStkDto = MvtStkDto.builder()
                .articleDto(ArticleDto.fromEntity(lig.getArticle()))
                .dateMvtStk(Instant.now())
                .typeStk(TypeMvtStk.SORTIE)
                .sourceMvtStk(SourceMvtStk.VENTE)
                .quantite(lig.getQuantite())
                .build();
        mvtStkService.sortieStock(mvtStkDto);
    }
}
