package com.seavus.rdbms.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated string field must be valid json
 *
 * @author Zoran.Talevski
 */
@Constraint(validatedBy = JsonValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface JsonField {

    String message() default "{com.seavus.rdbms.validator.JsonField.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
