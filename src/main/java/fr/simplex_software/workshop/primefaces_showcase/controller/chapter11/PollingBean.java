package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.text.*;
import java.util.*;

@Named
@ViewScoped
public class PollingBean implements Serializable
{
  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

  public void showMessage()
  {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
      FacesMessage.SEVERITY_INFO,
      "Updated feed at " + simpleDateFormat.format(new Date()) + " o'clock",
      null));
  }
}
