package com.antevgproject.neighbornest.infrastructure.validation;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private  Integer errorCode;
}
