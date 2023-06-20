package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;
import sn.aziz.gestiondestockbackend.dto.EntrepriseDto;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto dto){
        List<String> errors = new ArrayList<>();

        if (dto== null){
            errors.add("Veuillez renseigner le 'Nom' de l'entreprise");
            errors.add("Veuillez renseigner l''Email' de l'entreprise");
            errors.add("Veuillez renseigner le  'numéro téléphone' de l'entreprise");
            errors.add("Veuillez renseigner l''Adresse' de l'entreprise");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("Veuillez reseigner la description de l'entreprise");
        }

        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("Veuillez reseigner l'email de l'entreprise");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("Veuillez reseigner le numero de telephone de l'entreprise");
        }

        errors.addAll(AdresseValidator.validate(dto.getAdresseDto()));
        return errors;
    }
}
