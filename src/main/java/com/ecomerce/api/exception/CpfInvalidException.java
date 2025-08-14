package com.ecomerce.api.exception;

public class CpfInvalidException extends RuntimeException{

    public CpfInvalidException() { super("Cpf invalid");
    }

    public CpfInvalidException(String message) {
        super(message);
    }
}
