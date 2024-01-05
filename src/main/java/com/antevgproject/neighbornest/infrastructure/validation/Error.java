package com.antevgproject.neighbornest.infrastructure.validation;

import lombok.Getter;

@Getter

public enum Error {

    INCORRECT_CREDENTIALS("Wrong username or password",111),
    USERNAME_ALREADY_EXIST("Username is already taken",222);


    private final String message;
    private final Integer errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}

