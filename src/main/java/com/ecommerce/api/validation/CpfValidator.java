package com.ecommerce.api.validation;

import com.ecommerce.api.exception.CpfInvalidException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CPF, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            throw new CpfInvalidException();
        }

        String cpf = value.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            throw new CpfInvalidException();
        }

        return validateDigits(cpf);
    }

    private boolean validateDigits(String cpf) {

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        digit1 = (digit1 > 9) ? 0 : digit1;

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        digit2 = (digit2 > 9) ? 0 : digit2;

        if (digit1 == (cpf.charAt(9) - '0') && digit2 == (cpf.charAt(10) - '0')){
            return true;
        } else {
            throw new CpfInvalidException();
        }
    }
}