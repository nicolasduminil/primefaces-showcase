package fr.simplex_software.workshop.primefaces_showcase.validator;

import jakarta.validation.*;

public class CvcConstraintValidator implements ConstraintValidator<ValidCVC, Integer>
{
  @Override
  public void initialize(ValidCVC validCVC)
  {
  }

  @Override
  public boolean isValid(Integer cvc, ConstraintValidatorContext context)
  {
    boolean ret = false;

    if (cvc != null && cvc >= 0)
    {
      int length = (int) (Math.log10(cvc) + 1);
      ret = length >= 3 && length <= 4;
    }
    return ret;
  }
}
