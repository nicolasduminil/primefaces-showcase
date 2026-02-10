package fr.simplex_software.workshop.primefaces_showcase.validator;

import jakarta.validation.*;
import org.primefaces.validate.bean.*;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = CvcConstraintValidator.class)
@ClientConstraint(resolvedBy = CvcClientConstraint.class)
@Target({FIELD, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCVC
{
  String message() default "{invalid.cvc.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  // identifier of the select menu with cards
  String forCardMenu() default "";
}
