package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class SelectCheckboxBean implements Serializable
{
  private boolean selectedValue;

  private List<String> selectedCountries;

  public boolean isSelectedValue()
  {
    return selectedValue;
  }

  public void setSelectedValue(boolean selectedValue)
  {
    this.selectedValue = selectedValue;
  }

  public List<String> getSelectedCountries()
  {
    return selectedCountries;
  }

  public void setSelectedCountries(List<String> selectedCountries)
  {
    this.selectedCountries = selectedCountries;
  }

  public void addMessage()
  {
    MessageUtil.addInfoMessage(selectedValue ? "checkbox.checked" : "checkbox.unchecked");
  }
}
