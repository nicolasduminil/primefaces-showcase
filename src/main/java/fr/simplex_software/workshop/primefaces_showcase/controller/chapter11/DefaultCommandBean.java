package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class DefaultCommandBean implements Serializable
{
  private String text;

  private String btn = "btn1";

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public String getBtn()
  {
    return btn;
  }

  public void setBtn(String btn)
  {
    this.btn = btn;
  }

  public void showMessage(String button)
  {
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pressed button: " + button, null);
    FacesContext.getCurrentInstance().addMessage(null, msg);
  }
}
