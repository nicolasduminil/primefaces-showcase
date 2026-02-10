package fr.simplex_software.workshop.primefaces_showcase.validator;

import jakarta.faces.application.*;
import jakarta.faces.component.*;
import jakarta.faces.context.*;
import jakarta.faces.validator.*;

import java.util.*;

@FacesValidator("fr.simplex_software.workshop.primefaces_showcase.validator.RequiredCheckboxValidator")
public class RequiredCheckboxValidator implements Validator
{
  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
  {
    if (!(component instanceof UISelectBoolean))
      throw new IllegalArgumentException("RequiredCheckboxValidator must be registered on a UISelectBoolean");

    if (!Boolean.TRUE.equals(value))
    {
      String requiredMessage = ((UIInput) component).getRequiredMessage();

      if (requiredMessage == null && context.getApplication().getMessageBundle() != null)
      {
        requiredMessage =
          ResourceBundle.getBundle(context.getApplication().getMessageBundle(), context.getViewRoot().getLocale())
            .getString(UIInput.REQUIRED_MESSAGE_ID);
      }

      if (requiredMessage == null)
      {
        requiredMessage =  "%s: Validation Error: Value is required."
          .formatted(component.getAttributes().get("label"));
      }

      throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, requiredMessage, null));
    }
  }
}
