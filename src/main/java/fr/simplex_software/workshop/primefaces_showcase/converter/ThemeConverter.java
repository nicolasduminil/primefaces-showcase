package fr.simplex_software.workshop.primefaces_showcase.converter;

import fr.simplex_software.workshop.primefaces_showcase.controller.chapter2.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter2.*;
import jakarta.enterprise.context.*;
import jakarta.faces.component.*;
import jakarta.faces.context.*;
import jakarta.faces.convert.*;
import jakarta.inject.*;
import org.apache.commons.lang3.*;

import java.io.*;
import java.util.*;

@Named
@SessionScoped
public class ThemeConverter implements Serializable, Converter<Theme>
{
  @Inject
  private UserSettingsBean userSettingsBean;

  @Override
  public Theme getAsObject(FacesContext context, UIComponent component, String value)
  {
    return userSettingsBean.getAvailableThemes().stream()
      .filter(theme -> theme.getName().equals(value))
      .findFirst()
      .orElse(null);
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, Theme theme) throws ConverterException
  {
    return theme == null ? "" : theme.getName();
  }
}
