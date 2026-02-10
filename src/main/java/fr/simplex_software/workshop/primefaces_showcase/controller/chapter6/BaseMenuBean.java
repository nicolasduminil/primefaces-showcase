package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.event.*;

import java.io.*;

public abstract class BaseMenuBean implements Serializable
{
  public void save(ActionEvent ae)
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", null));
  }

  public void update(ActionEvent ae)
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated", null));
  }

  public void delete(ActionEvent ae)
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted", null));
  }

  public String doSomething()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Done", null));

    return null;
  }
}
