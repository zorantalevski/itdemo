package com.seavus.rdbms.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;

public class JsonValidator implements ConstraintValidator<JsonField, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (Strings.isNullOrEmpty(value)) {
            return false;
        }
        try {
            new ObjectMapper().readTree(value);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
