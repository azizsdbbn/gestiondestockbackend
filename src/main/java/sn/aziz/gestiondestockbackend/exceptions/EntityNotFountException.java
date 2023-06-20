package sn.aziz.gestiondestockbackend.exceptions;

import lombok.Getter;

public class EntityNotFountException extends RuntimeException{
    @Getter
    private  Errorcodes errorcodes;

    public EntityNotFountException( String message) {
        super(message);
    }
    public EntityNotFountException( String message, Throwable cause) {
        super(message, cause);
    }
    public EntityNotFountException(String message,Throwable cause, Errorcodes errorcodes) {
        super(message,cause);
        this.errorcodes = errorcodes;
    }
    public EntityNotFountException(String message, Errorcodes errorcodes) {
        super(message);
        this.errorcodes = errorcodes;
    }

}
