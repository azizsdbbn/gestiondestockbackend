package sn.aziz.gestiondestockbackend.controller.api;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.aziz.gestiondestockbackend.dto.UtilisateurDto;

import java.util.List;

import static sn.aziz.gestiondestockbackend.utils.Constants.APP_ROOT;
import static sn.aziz.gestiondestockbackend.utils.Constants.UTILISATEUR_ENDPOINT;

@Api("utilisateurs")
public interface UtilisateurApi {

    @PostMapping(value = UTILISATEUR_ENDPOINT+ "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto dto);
    @GetMapping(value = UTILISATEUR_ENDPOINT + "/{idUtilisateur}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(Integer id);
    @GetMapping(value = UTILISATEUR_ENDPOINT + "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();
    @DeleteMapping(value =UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idUtilisateur") Integer id);
}
