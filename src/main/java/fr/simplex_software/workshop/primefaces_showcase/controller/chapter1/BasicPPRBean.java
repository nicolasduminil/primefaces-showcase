package fr.simplex_software.workshop.primefaces_showcase.controller.chapter1;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class BasicPPRBean implements Serializable
{
  private String value;

  public String updateValue()
  {
    value = String.valueOf(System.currentTimeMillis());
    return null;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }
}
