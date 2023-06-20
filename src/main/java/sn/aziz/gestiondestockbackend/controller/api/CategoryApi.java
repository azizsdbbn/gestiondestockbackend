package sn.aziz.gestiondestockbackend.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sn.aziz.gestiondestockbackend.dto.ArticleDto;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;

import java.util.List;

import static sn.aziz.gestiondestockbackend.utils.Constants.APP_ROOT;
@Api("categories")
public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une categorie", notes = "Cette methode permet d'enregistrer ou modifier une categorie", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet categorie cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet categorie n'est pas valide")
    })
    CategoryDto save(@RequestBody CategoryDto dto);
    @GetMapping(value = APP_ROOT + "/categories/{idCategorie}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(Integer id);

    @GetMapping(value = APP_ROOT + "/categories/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategorie}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idCategorie") Integer id);
}
