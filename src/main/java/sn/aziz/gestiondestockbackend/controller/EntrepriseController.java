package sn.aziz.gestiondestockbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.EntrepriseApi;
import sn.aziz.gestiondestockbackend.dto.EntrepriseDto;
import sn.aziz.gestiondestockbackend.services.EntrepriseService;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;
    @Autowired
    public void setArticleService(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }
    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }
    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }
    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }
    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }
    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
