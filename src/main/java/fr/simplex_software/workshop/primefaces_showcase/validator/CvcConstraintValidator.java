package fr.simplex_software.workshop.primefaces_showcase.validator;

import io.quarkus.runtime.annotations.*;
import jakarta.validation.*;
import org.apache.myfaces.util.lang.*;

@RegisterForReflection
public class CvcConstraintValidator implements ConstraintValidator<ValidCVC, String>
{
  @Override
  public void initialize(ValidCVC validCVC)
  {
  }

  @Override
  public boolean isValid(String cvc, ConstraintValidatorContext context)
  {
    boolean ret = false;

    if (!StringUtils.isBlank(cvc))
    {
      int length = cvc.length();
      ret = cvc.matches("\\d{3,4}");
    }
    return ret;
  }
}
