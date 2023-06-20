package sn.aziz.gestiondestockbackend.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.aziz.gestiondestockbackend.dto.UtilisateurDto;
import sn.aziz.gestiondestockbackend.exceptions.EntityNotFountException;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;
import sn.aziz.gestiondestockbackend.exceptions.InvalidEntityException;
import sn.aziz.gestiondestockbackend.models.Utilisateur;
import sn.aziz.gestiondestockbackend.repositories.UtilisateurRepository;
import sn.aziz.gestiondestockbackend.services.UtilisateurService;
import sn.aziz.gestiondestockbackend.validators.UtilisateurValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur' n'est pas valide",
                    Errorcodes.ARTICLE_NOT_VALID, errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto))
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFountException("Aucune entreprise avec ID = " + id + "n'est pas trouvé la BDD",
                        Errorcodes.ARTICLE_NOT_FOND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Entreprise ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }
}
