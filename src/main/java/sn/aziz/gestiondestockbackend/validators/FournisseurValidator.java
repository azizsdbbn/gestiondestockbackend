package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.ClientDto;
import sn.aziz.gestiondestockbackend.dto.FournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le 'Nom' du fournisseur");
            errors.add("Veuillez renseigner le 'Prenom' du fournisseur");
            errors.add("Veuillez renseigner l 'Email' du fournisseur");
            errors.add("Veuillez renseigner le 'Numéro téléphone' du fournisseur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le 'Nom' du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veuillez renseigner le 'Prenom' du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l 'Email' du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getNumTel())){
            errors.add("Veuillez renseigner le 'Numéro téléphone' du fournisseur");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresseDto()));
        return errors;
    }
}
