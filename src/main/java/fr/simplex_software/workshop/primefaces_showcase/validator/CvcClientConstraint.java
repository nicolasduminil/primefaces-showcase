package fr.simplex_software.workshop.primefaces_showcase.validator;

import jakarta.validation.metadata.*;
import org.apache.commons.lang3.*;
import org.primefaces.validate.bean.*;

import java.util.*;

public class CvcClientConstraint implements ClientValidationConstraint
{
  private static final String CARDMENU_METADATA = "data-forcardmenu";

  @Override
  public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor)
  {
    Map<String, Object> metadata = new HashMap<>();
    @SuppressWarnings("rawtypes")
    Map attrs = constraintDescriptor.getAttributes();
    String forCardMenu = (String) attrs.get("forCardMenu");
    if (StringUtils.isNotBlank(forCardMenu))
      metadata.put(CARDMENU_METADATA, forCardMenu);
    return metadata;
  }

  @Override
  public String getValidatorId()
  {
    return ValidCVC.class.getSimpleName();
  }
}
