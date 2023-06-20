package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CategoryDto;
import sn.aziz.gestiondestockbackend.dto.CommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class CmdeClientValidator {

    public static List<String> validate(CommandeClientDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (dto.getDateCmd() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (dto.getClientDto() == null || dto.getClientDto().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }
}
