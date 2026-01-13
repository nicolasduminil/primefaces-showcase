package fr.simplex_software.workshop.primefaces_showcase.controller.chapter1;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class LocalizationBean implements Serializable
{
  private boolean selectedValue = true;

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