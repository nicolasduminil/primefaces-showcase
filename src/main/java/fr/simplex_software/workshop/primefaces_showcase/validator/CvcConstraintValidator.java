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
    System.out.println(">>> CvcConstraintValidator.isValid() : cvc = " + cvc);
    if (cvc != null && cvc >= 0)
    {
      int length = (int) (Math.log10(cvc) + 1);
      System.out.println (">>> CvcConstraintValidator.isValid() : cvc = " + cvc + ", length = " + length);
      ret = length >= 3 && length <= 4;
    }
    return ret;
  }
}
