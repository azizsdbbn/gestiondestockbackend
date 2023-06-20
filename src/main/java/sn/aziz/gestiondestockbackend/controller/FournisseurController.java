package sn.aziz.gestiondestockbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.aziz.gestiondestockbackend.controller.api.FournisseurApi;
import sn.aziz.gestiondestockbackend.dto.FournisseurDto;
import sn.aziz.gestiondestockbackend.services.FournisseurService;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;
    @Autowired
    public void setArticleService(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }
    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }
    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }
    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }
    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }
    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
