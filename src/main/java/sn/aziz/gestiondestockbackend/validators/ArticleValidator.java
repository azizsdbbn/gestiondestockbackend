package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.ArticleDto;


import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto){
        List<String> errors = new ArrayList<>();

        if (dto ==null){
            errors.add("Veuillez renseigner le 'code' de l'article");
            errors.add("Veuillez renseigner la 'désignation' de l'article");
            errors.add("Veuillez renseigner le 'prix unitaire HT' de l'article");
            errors.add("Veuillez renseigner le 'taux TVA 'de l'article");
            errors.add("Veuillez renseigner le 'prix unitaire TTC' de l'article");
            errors.add("Veuillez selectionner une catégorie");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez renseigner le 'code' de l'article");
        }
        if (!StringUtils.hasLength(dto.getDesignation())){
            errors.add("Veuillez renseigner la 'désignation' de l'article");
        }
        if (dto.getPrixUnitaireHt() ==null){
            errors.add("Veuillez renseigner le 'prix unitaire HT' de l'article");
        }
        if (dto.getTauxTva() ==null){
            errors.add("Veuillez renseigner le 'taux TVA 'de l'article");
        }
        if (dto.getPrixUnitaireTtc() ==null){
            errors.add("Veuillez renseigner le 'prix unitaire TTC' de l'article");
        }
        if (dto.getCategoryDto() ==null){
            errors.add("Veuillez selectionner une catégorie");
        }
        return errors;
    }
}
