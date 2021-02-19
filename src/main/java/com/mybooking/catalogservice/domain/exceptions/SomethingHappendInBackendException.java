package com.mybooking.catalogservice.domain.exceptions;

public class SomethingHappendInBackendException extends  Exception {
    @Override
    public String getMessage() {
        return "Tenemos dificultades tecnicas al procesar su peticiion, favor contacte";
    }

}
