package fr.simplex_software.workshop.primefaces_showcase.converter;

import jakarta.faces.application.*;
import jakarta.faces.component.*;
import jakarta.faces.context.*;
import jakarta.faces.convert.*;
import org.apache.commons.lang3.*;

import java.io.*;
import java.util.*;

@FacesConverter(value = "fr.simplex_software.workshop.primefaces_showcaseconverter.LocaleConverter")
public class LocaleConverter implements Converter<Locale>, Serializable
{
  @Override
  public Locale getAsObject(final FacesContext fc, final UIComponent component, final String value)
  {
    return StringUtils.isBlank(value) ?
      fc.getApplication().getDefaultLocale() : getLocaleObject(value);
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, Locale locale) throws ConverterException
  {
    return locale == null ? getLocaleString(facesContext.getApplication().getDefaultLocale()) : getLocaleString(locale);
  }

  public static Locale getLocaleObject(final String locale)
  {
    try
    {
      return Locale.forLanguageTag(locale);
    }
    catch (Exception e)
    {
      throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR.toString(),
        "%sdoes not represent a valid locale%s".formatted(locale, StringUtils.EMPTY)));
    }
  }

  public static String getLocaleString(final Locale locale)
  {
    return StringUtils.isBlank(locale.getCountry()) ? locale.getLanguage() :
      "%s-%s".formatted(locale.getLanguage(), locale.getCountry());
  }
}
