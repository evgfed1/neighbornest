package com.antevgproject.neighbornest.infrastructure.validation;

import com.antevgproject.neighbornest.domain.user.User;
import com.antevgproject.neighbornest.infrastructure.exception.BusinessException;

import java.util.Optional;

import static com.antevgproject.neighbornest.infrastructure.validation.Error.INCORRECT_CREDENTIALS;


public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }


}
