package fr.simplex_software.workshop.primefaces_showcase.controller.chapter1;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.time.*;
import java.time.format.*;

@Named
@ViewScoped
public class BasicPPRBean implements Serializable
{
  private String value ;
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
  public String updateValue()
  {
    value = String.valueOf(formatter.format(LocalDateTime.now()));
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
