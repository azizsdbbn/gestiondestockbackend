package sn.aziz.gestiondestockbackend.controller.api;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.aziz.gestiondestockbackend.dto.EntrepriseDto;

import java.util.List;

import static sn.aziz.gestiondestockbackend.utils.Constants.APP_ROOT;
public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT + "/entreprises/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);
    @GetMapping(value = APP_ROOT + "/entreprises/{idEntreprise}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(Integer id);
    @GetMapping(value = APP_ROOT + "/entreprises/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/entreprises/delete/{idEntreprise}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idEntreprise") Integer id);
}
