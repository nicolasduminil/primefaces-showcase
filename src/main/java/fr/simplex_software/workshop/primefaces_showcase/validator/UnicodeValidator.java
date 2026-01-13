package fr.simplex_software.workshop.primefaces_showcase.validator;

import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.validate.ClientValidator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@FacesValidator("fr.simplex_software.workshop.primefaces_showcaseUnicodeValidator")
public class UnicodeValidator implements
                              Validator, ClientValidator, Serializable {

    private static final String MESSAGE_METADATA = "data-param";
    private static final String REGEX = "[\\p{L}\\-\\'\\�\\`\\s]+";

    private String msgparam;

    @Override
    public void validate(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        boolean valid = value.toString().matches(REGEX);
        if (!valid) {
            String param = MessageUtil.getMessage(msgparam);
            String msg = MessageUtil.getMessage("invalid.unicode", param);
            throw new ValidatorException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, null, msg));
        }
    }

    @Override
    public Map<String, Object> getMetadata() {
        Map<String, Object> metadata = new HashMap<String, Object>();
        String param = MessageUtil.getMessage(msgparam);
        metadata.put(MESSAGE_METADATA, param);

        return metadata;
    }

    @Override
    public String getValidatorId() {
        return UnicodeValidator.class.getSimpleName();
    }

    public String getMsgparam() {
        return msgparam;
    }

    public void setMsgparam(String msgparam) {
        this.msgparam = msgparam;
    }
}
