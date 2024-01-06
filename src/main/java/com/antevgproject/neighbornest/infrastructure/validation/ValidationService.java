package com.antevgproject.neighbornest.infrastructure.validation;

import com.antevgproject.neighbornest.domain.resident.Resident;
import com.antevgproject.neighbornest.domain.user.User;
import com.antevgproject.neighbornest.infrastructure.exception.BusinessException;
import com.antevgproject.neighbornest.infrastructure.exception.GenericException;

import java.util.Optional;

import static com.antevgproject.neighbornest.infrastructure.validation.Error.INCORRECT_CREDENTIALS;
import static com.antevgproject.neighbornest.infrastructure.validation.Error.USERNAME_ALREADY_EXIST;


public class ValidationService {
    private ValidationService() {
    }

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static User compareValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(USERNAME_ALREADY_EXIST.getMessage(), USERNAME_ALREADY_EXIST.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void isExistByUsername(Optional<User> optionalUser) {
        if (optionalUser.isPresent()) {
            throw new GenericException("Username already exists", "Choose another username");
        }
    }

    public static void isExistByPhone(boolean existByPhone) {
        if (existByPhone) {
            throw new GenericException("Phone already exists", "Choose another phone");
        }
    }

    public static void isExistByEmail(boolean existByEmail) {
        if (existByEmail) {
            throw new GenericException("Email already exists", "Choose another email");
        }
    }

}
