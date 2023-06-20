package sn.aziz.gestiondestockbackend.controller.api;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.aziz.gestiondestockbackend.dto.FournisseurDto;

import java.util.List;

import static sn.aziz.gestiondestockbackend.utils.Constants.APP_ROOT;
public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseurs/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);
    @GetMapping(value = APP_ROOT + "/fournisseurs/{idFournisseur}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(Integer id);
    @GetMapping(value = APP_ROOT + "/fournisseurs/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/fournisseurs/delete/{idFournisseur}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idFournisseur") Integer id);
}
