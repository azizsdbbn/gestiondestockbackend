package sn.aziz.gestiondestockbackend.validators;

import org.springframework.util.StringUtils;
import sn.aziz.gestiondestockbackend.dto.CommandeClientDto;
import sn.aziz.gestiondestockbackend.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCmdeClientValidator {

    public static List<String> validate(LigneCommandeClientDto dto){
        List<String> errors = new ArrayList<>();

        return errors;
    }
}
