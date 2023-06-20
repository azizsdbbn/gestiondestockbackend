package sn.aziz.gestiondestockbackend.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CommandeClientDto;
import sn.aziz.gestiondestockbackend.dto.LigneCommandeClientDto;
import sn.aziz.gestiondestockbackend.exceptions.EntityNotFountException;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;
import sn.aziz.gestiondestockbackend.exceptions.InvalidEntityException;
import sn.aziz.gestiondestockbackend.models.*;
import sn.aziz.gestiondestockbackend.repositories.ArticleRepository;
import sn.aziz.gestiondestockbackend.repositories.ClientRepository;
import sn.aziz.gestiondestockbackend.repositories.CmdClientRepository;
import sn.aziz.gestiondestockbackend.repositories.LigCmdClientRepository;
import sn.aziz.gestiondestockbackend.services.CommandeClientService;
import sn.aziz.gestiondestockbackend.services.MvtStkService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    private CmdClientRepository cmdClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigCmdClientRepository ligCmdClientRepository;
    private MvtStkService mvtStkService;
    @Autowired
    public CommandeClientServiceImpl(CmdClientRepository cmdClientRepository,
                                     ClientRepository clientRepository,
                                     ArticleRepository articleRepository,
                                     LigCmdClientRepository ligCmdClientRepository) {
        this.cmdClientRepository = cmdClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligCmdClientRepository = ligCmdClientRepository;
    }


    @Override
    public CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return null;
    }

    @Override
    public CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return null;
    }

    @Override
    public CommandeClientDto updateClient(Integer idCommande, Integer idClient) {
        return null;
    }

    @Override
    public CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle) {
        return null;
    }

    @Override
    public CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return null;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        return null;
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return null;
    }

    @Override
    public List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
        return ligCmdClientRepository.findAllByCommandeClientId(idCommande).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
