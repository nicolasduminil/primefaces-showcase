package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.faces.model.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class CheckboxMenuBean implements Serializable
{
  private List<SelectItem> languages = List.of(
    new SelectItem(new Locale("de"), "German"),
    new SelectItem(new Locale("en"), "English"),
    new SelectItem(new Locale("it"), "Italian"),
    new SelectItem(new Locale("fr"), "French")
  );
  private Map<String, String> color = Map.of (
    "Red", "Red",
    "Green", "Green",
    "Blue", "Blue"
  );
  private List<Locale> selectedLanguages;
  private List<String> selectedColors;

  public List<SelectItem> getLanguages()
  {
    return languages;
  }

  public Map<String, String> getColors()
  {
    return color;
  }

  public List<Locale> getSelectedLanguages()
  {
    return selectedLanguages;
  }

  public void setSelectedLanguages(List<Locale> selectedLanguages)
  {
    this.selectedLanguages = selectedLanguages;
  }

  public List<String> getSelectedColors()
  {
    return selectedColors;
  }

  public void setSelectedColors(List<String> selectedColors)
  {
    this.selectedColors = selectedColors;
  }
}
