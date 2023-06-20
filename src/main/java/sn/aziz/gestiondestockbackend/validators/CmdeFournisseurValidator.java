package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CommandeClientDto;
import sn.aziz.gestiondestockbackend.dto.CommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class CmdeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto dto){
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
        if (dto.getFournisseurDto() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (dto.getFournisseurDto() == null || dto.getFournisseurDto().getId() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }

        return errors;
   }
}
