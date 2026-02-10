package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class MenubarBean implements Serializable
{
  public void createFolder()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Create Folder", null));
  }

  public void createVideo()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Create Video File", null));
  }

  public void createHTML()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Create HTML File", null));
  }

  public void properties()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Properties", null));
  }

  public void cut()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Cut", null));
  }

  public void copy()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Copy", null));
  }

  public void paste()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Paste", null));
  }

  public void zoomIn()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Zoom In", null));
  }

  public void zoomOut()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Zoom Out", null));
  }

  public void viewIcons()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "View Icons", null));
  }

  public void viewCompact()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "View Compact", null));
  }

  public void viewDetails()
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "View Details", null));
  }

  public String info()
  {
    FacesContext.getCurrentInstance().getExternalContext().getFlash().put("helpVisible", true);
    return "/views/chapter6/menubar.xhtml";
  }
}
