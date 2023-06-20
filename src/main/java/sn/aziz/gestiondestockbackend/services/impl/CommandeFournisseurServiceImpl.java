package sn.aziz.gestiondestockbackend.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CommandeFournisseurDto;
import sn.aziz.gestiondestockbackend.dto.LigneCommandeFournisseurDto;
import sn.aziz.gestiondestockbackend.exceptions.EntityNotFountException;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;
import sn.aziz.gestiondestockbackend.exceptions.InvalidEntityException;
import sn.aziz.gestiondestockbackend.models.*;
import sn.aziz.gestiondestockbackend.repositories.*;
import sn.aziz.gestiondestockbackend.services.CommandeFournisseurService;
import sn.aziz.gestiondestockbackend.validators.CmdeFournisseurValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CmdFournisseurRepository cmdFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
    private LigCmdFournisseurRepository ligCmdFournisseurRepository;
    @Autowired
    public CommandeFournisseurServiceImpl(CmdFournisseurRepository cmdFournisseurRepository,
                                          FournisseurRepository fournisseurRepository,
                                          ArticleRepository articleRepository,
                                          LigCmdFournisseurRepository ligCmdFournisseurRepository) {
        this.cmdFournisseurRepository = cmdFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligCmdFournisseurRepository = ligCmdFournisseurRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto){
        List<String> errors = CmdeFournisseurValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("commande client is not valid {}", dto);
            throw new InvalidEntityException("La commande client' n'est pas valide",
                    Errorcodes.CMD_FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseurDto().getId());
        if (fournisseur.isEmpty()){
            log.warn("fournisseur with ID was not found in the DB", dto.getFournisseurDto().getId());
            throw new EntityNotFountException("aucun fournisseur dont ID" +dto.getFournisseurDto().getId()+
                    "n'a été trouvé dans la BDD", Errorcodes.FOURNISSEUR_NOT_FOND);
        }
        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeFournisseurDtos() !=null){
            dto.getLigneCommandeFournisseurDtos().forEach(lifcmdfsr ->{
                if (lifcmdfsr.getArticleDto()!=null){
                    Optional<Article> article = articleRepository.findById(lifcmdfsr.getArticleDto().getId());
                    if (article.isEmpty()){
                        articleErrors.add("L'article avec ID"
                                +lifcmdfsr.getArticleDto().getId()+ "n'existe pas dans la BDD");
                    }
                }else {
                    articleErrors.add("Impossible d'enrégistrer un article NULL");
                }
            });
        }
        if (!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("l'article n'existe pas la BDD",
                    Errorcodes.ARTICLE_NOT_VALID, articleErrors);
        }

        CommandeFournisseur savedCmdFsr =cmdFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

       if (dto.getLigneCommandeFournisseurDtos() != null){
           dto.getLigneCommandeFournisseurDtos().forEach(lifcmdfsr ->{
               LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(lifcmdfsr);
               ligneCommandeFournisseur.setCommandeFournisseur(savedCmdFsr);
               ligCmdFournisseurRepository.save(ligneCommandeFournisseur);
           });
       }

        return CommandeFournisseurDto.fromEntity(savedCmdFsr);
    }

    @Override
    public CommandeFournisseurDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return null;
    }

    @Override
    public CommandeFournisseurDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return null;
    }

    @Override
    public CommandeFournisseurDto updateFournisseur(Integer idCommande, Integer idFournisseur) {
        return null;
    }

    @Override
    public CommandeFournisseurDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
        return null;
    }

    @Override
    public CommandeFournisseurDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return null;
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null){
            log.error("Commande fournisseur Id is NULL");
            return null;
        }
        return cmdFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFountException("Aucune commande fournisseur avec l'ID"+ id+ "dans la BDD",
                        Errorcodes.CMD_FOURNISSEUR_NOT_FOND)
                );
    }
    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Commande fournisseur CODE is null");
            return null;
        }
        return cmdFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFountException("Aucune commande fournisseur avec le CODE" +code+ "dans la BDD",
                        Errorcodes.CMD_FOURNISSEUR_NOT_FOND)
                );
    }
    @Override
    public List<CommandeFournisseurDto> findAll() {
        return cmdFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande) {
        return ligCmdFournisseurRepository.findAllByCommandeFournisseurId(idCommande).stream()
                .map(LigneCommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Commande fournisseur Id is NULL");
            return;
        }
        cmdFournisseurRepository.deleteById(id);
    }
}
