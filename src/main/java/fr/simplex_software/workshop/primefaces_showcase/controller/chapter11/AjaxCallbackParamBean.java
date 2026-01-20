package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.application.*;
import jakarta.faces.component.*;
import jakarta.faces.context.*;
import jakarta.faces.event.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.*;
import org.primefaces.context.*;

import java.io.*;

@Named
@ViewScoped
public class AjaxCallbackParamBean implements Serializable
{
  private String name;

  public void save(ActionEvent ae)
  {
    PrimeFaces.Ajax requestContext = PrimeFaces.current().ajax();

    String message;
    FacesMessage.Severity severity;
    UIInput input = (UIInput) ae.getComponent().findComponent("name");

    if ("PrimeFaces Cookbook".equals(name))
    {
      message = "All right!";
      severity = FacesMessage.SEVERITY_INFO;

      requestContext.addCallbackParam("validName", true);
      input.setValid(true);
    }
    else
    {
      message = "Name is wrong, try again";
      severity = FacesMessage.SEVERITY_ERROR;

      requestContext.addCallbackParam("validName", false);
      input.setValid(false);
    }

    FacesMessage msg = new FacesMessage(severity, message, null);
    FacesContext.getCurrentInstance().addMessage(null, msg);
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
