package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;
import sn.aziz.gestiondestockbackend.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le 'Nom' du client");
            errors.add("Veuillez renseigner le 'Prenom' du client");
            errors.add("Veuillez renseigner l 'Email' du client");
            errors.add("Veuillez renseigner le 'Numéro téléphone' du client");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le 'Nom' du client");
        }
        if (!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez renseigner le 'Prenom' du client");
        }
        if (!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l 'Email' du client");
        }
        if (!StringUtils.hasLength(dto.getNumTel())){
            errors.add("Veuillez renseigner le 'Numéro téléphone' du client");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresseDto()));
        return errors;
    }
}
