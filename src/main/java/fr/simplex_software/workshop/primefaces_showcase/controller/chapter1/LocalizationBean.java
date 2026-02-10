package fr.simplex_software.workshop.primefaces_showcase.controller.chapter1;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.context.*;
import jakarta.faces.event.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class LocalizationBean implements Serializable
{
  private String localeCode;
  private boolean selectedValue = true;

  private static Map<String, Object> countries = Map.of(
    "English", Locale.ENGLISH, "French", Locale.FRENCH
  );

  public Map<String, Object> getCountriesInMap()
  {
    return countries;
  }


  public String getLocaleCode()
  {
    return localeCode;
  }

  public void setLocaleCode(String localeCode)
  {
    this.localeCode = localeCode;
  }

  public void countryLocaleCodeChanged()
  {
    countries.entrySet().stream()
      .filter(entry ->
        entry.getValue().toString().equals(localeCode))
      .findFirst()
      .ifPresent(entry ->
        FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue()));
  }

  public boolean isSelectedValue()
  {
    return selectedValue;
  }

  public void setSelectedValue(boolean selectedValue)
  {
    this.selectedValue = selectedValue;
  }

  public String addMessage()
  {
    MessageUtil.addInfoMessage("broadcast.message");
    return null;
  }
}