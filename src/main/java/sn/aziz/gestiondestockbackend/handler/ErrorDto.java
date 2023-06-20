package sn.aziz.gestiondestockbackend.handler;

import lombok.*;
import sn.aziz.gestiondestockbackend.exceptions.Errorcodes;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private Errorcodes code;
    private String message;
    private List<String> errors = new ArrayList<>();
}
