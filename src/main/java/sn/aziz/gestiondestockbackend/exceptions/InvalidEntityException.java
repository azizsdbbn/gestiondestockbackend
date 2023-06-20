package sn.aziz.gestiondestockbackend.exceptions;

import lombok.Getter;
import sn.aziz.gestiondestockbackend.models.Article;

import java.util.List;

public class InvalidEntityException extends  RuntimeException{

    @Getter
    private  Errorcodes errorcodes;
    @Getter
    List<String> errors;

    public InvalidEntityException( String message) {
        super(message);
    }
    public InvalidEntityException( String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidEntityException(String message,Throwable cause, Errorcodes errorcodes) {
        super(message,cause);
        this.errorcodes = errorcodes;
    }
    public InvalidEntityException(String message, Errorcodes errorcodes) {
        super(message);
        this.errorcodes = errorcodes;
    }
    public InvalidEntityException(String message, Errorcodes errorcodes, List<String> errors) {
        super(message);
        this.errorcodes = errorcodes;
        this.errors= errors;
    }
}
