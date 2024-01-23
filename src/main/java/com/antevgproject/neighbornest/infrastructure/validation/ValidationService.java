package com.antevgproject.neighbornest.infrastructure.validation;

import com.antevgproject.neighbornest.domain.consumption.Consumption;
import com.antevgproject.neighbornest.domain.user.User;
import com.antevgproject.neighbornest.infrastructure.exception.BusinessException;
import com.antevgproject.neighbornest.infrastructure.exception.GenericException;

import java.util.Optional;

import static com.antevgproject.neighbornest.infrastructure.validation.Error.*;


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

    public static void isExistByName(boolean existByName) {
        if (existByName) {
            throw new GenericException("Name already exists", "Choose another name");
        }
    }

    public static void isExistByRegNumber(boolean existByRegNumber) {
        if (existByRegNumber){
            throw new GenericException("Registration number already exists", "Choose another number");
        }
    }

    public static void isExistByAddress(boolean existByAddress) {
        if (existByAddress){
            throw new GenericException("Address already exists", "Choose another address");
        }
    }

    public static void isExistByCadastral(boolean existByCadastral) {
        if (existByCadastral){
            throw new GenericException("Cadastral already exists", "Choose another cadastral");
        }
    }

    public static Consumption getValidConsumption(Optional<Consumption> optionalConsumption) {
        if (optionalConsumption.isEmpty()) {
            throw new BusinessException(USERNAME_ALREADY_EXIST.getMessage(), USERNAME_ALREADY_EXIST.getErrorCode());
        }
        return optionalConsumption.get();
    }

    public static Consumption getValidConsumptionByDate(Optional<Consumption> optionalConsumption) {
        if (optionalConsumption.isEmpty()) {
            throw new BusinessException(CONSUMPTIONVALUES_ALREADY_PROVIDED.getMessage(), CONSUMPTIONVALUES_ALREADY_PROVIDED.getErrorCode());
        }
        return optionalConsumption.get();
    }
}
