package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class TargetableMessagesBean implements Serializable
{
  public String addSaveMessage()
  {
    addMessage("save", FacesMessage.SEVERITY_INFO,
      "Sample info message",
      "First data was successfully saved");
    addMessage("save", FacesMessage.SEVERITY_INFO,
      "Sample info message",
      "Second data was successfully saved");

    return null;
  }

  public String addChangeMessage()
  {
    addMessage("change", FacesMessage.SEVERITY_INFO,
      "Sample info message",
      "Data was successfully changed");

    return null;
  }

  public String addDeleteMessage()
  {
    addMessage(null, FacesMessage.SEVERITY_INFO,
      "Sample info message",
      "Data was successfully deleted");

    return null;
  }

  public String addErrorMessage()
  {
    addMessage(null, FacesMessage.SEVERITY_ERROR,
      "Sample error message",
      "Operation failed");

    return null;
  }

  private void addMessage(String key, FacesMessage.Severity severity, String message, String detail)
  {
    FacesContext.getCurrentInstance().addMessage(key, new FacesMessage(severity, message, detail));
  }
}
