package com.antevgproject.neighbornest.infrastructure.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GenericException extends RuntimeException{

    private  final String description;
    private final String error;

    public GenericException(String description, String error) {
        super(description);
        this.description = description;
        this.error = error;
    }
}
