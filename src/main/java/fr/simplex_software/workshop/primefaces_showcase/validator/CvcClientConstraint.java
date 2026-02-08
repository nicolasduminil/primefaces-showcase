package fr.simplex_software.workshop.primefaces_showcase.validator;

import io.quarkus.runtime.annotations.*;
import jakarta.validation.*;
import jakarta.validation.metadata.*;
import org.apache.commons.lang3.*;
import org.primefaces.validate.bean.*;

import java.util.*;

@RegisterForReflection
public class CvcClientConstraint extends AbstractClientValidationConstraint
{
  public CvcClientConstraint()
  {
    super("invalid.cvc","data-forcardmenu");
  }

  @Override
  public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor)
  {
    Map<String, Object> metadata = super.getMetadata(constraintDescriptor);
    Map<String, Object> attrs = constraintDescriptor.getAttributes();
    Object forCardMenu = attrs.get("forCardMenu");
    if (forCardMenu != null)
      metadata.put("data-forcardmenu", forCardMenu.toString());
    return metadata;
  }

  @Override
  public String getValidatorId()
  {
    return "ValidCVC";
  }
}
