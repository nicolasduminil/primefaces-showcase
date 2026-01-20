package fr.simplex_software.workshop.primefaces_showcase.validator;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.application.*;
import jakarta.faces.component.*;
import jakarta.faces.context.*;
import jakarta.faces.validator.*;
import org.primefaces.validate.*;

import java.io.*;
import java.util.*;

@FacesValidator("fr.simplex_software.workshop.primefaces_showcaseUnicodeValidator")
public class UnicodeValidator implements Validator<Object>, ClientValidator, Serializable
{
  private static final String MESSAGE_METADATA = "data-param";
  private static final String REGEX = "[\\p{L}\\-'�`\\s]+";

  private String msgparam;

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
  {
    if (value != null && !value.toString().matches(REGEX))
      throw new ValidatorException(
        new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
          MessageUtil.getMessage("invalid.unicode", MessageUtil.getMessage(msgparam))));
  }

  @Override
  public Map<String, Object> getMetadata()
  {
    Map<String, Object> metadata = new HashMap<>();
    metadata.put(MESSAGE_METADATA, MessageUtil.getMessage(msgparam));
    return metadata;
  }

  @Override
  public String getValidatorId()
  {
    return UnicodeValidator.class.getSimpleName();
  }

  public String getMsgparam()
  {
    return msgparam;
  }

  public void setMsgparam(String msgparam)
  {
    this.msgparam = msgparam;
  }
}
