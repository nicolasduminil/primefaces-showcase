package fr.simplex_software.workshop.primefaces_showcase.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.component.UISelectBoolean;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import java.util.ResourceBundle;

/**
 * RequiredCheckboxValidator
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@FacesValidator("fr.simplex_software.workshop.primefaces_showcase.validator.RequiredCheckboxValidator")
public class RequiredCheckboxValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (!(component instanceof UISelectBoolean)) {
			throw new IllegalArgumentException("RequiredCheckboxValidator must be registered on a UISelectBoolean");
		}

		if (!Boolean.TRUE.equals(value)) {
			String requiredMessage = ((UIInput) component).getRequiredMessage();

			if (requiredMessage == null && context.getApplication().getMessageBundle() != null) {
				requiredMessage =
				    ResourceBundle.getBundle(context.getApplication().getMessageBundle(), context.getViewRoot().getLocale())
				                  .getString(UIInput.REQUIRED_MESSAGE_ID);
			}

			if (requiredMessage == null) {
				requiredMessage = component.getAttributes().get("label") + ": Validation Error: Value is required.";
			}

			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, requiredMessage, null));
		}
	}
}
