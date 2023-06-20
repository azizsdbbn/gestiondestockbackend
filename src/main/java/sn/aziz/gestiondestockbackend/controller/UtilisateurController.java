package sn.aziz.gestiondestockbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.UtilisateurApi;
import sn.aziz.gestiondestockbackend.dto.UtilisateurDto;
import sn.aziz.gestiondestockbackend.services.UtilisateurService;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;
    @Autowired
    public void setArticleService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }
    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }
    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }
    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
