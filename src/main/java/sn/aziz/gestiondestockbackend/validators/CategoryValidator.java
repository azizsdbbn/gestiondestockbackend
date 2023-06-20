package sn.aziz.gestiondestockbackend.validators;

import ch.qos.logback.core.status.StatusUtil;
import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;
import sn.aziz.gestiondestockbackend.dto.UtilisateurDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if (!StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code catégorie");
        }
        return errors;
    }
}
