package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.annotation.*;
import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.menu.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class ParametrizedCommandBean implements Serializable
{
  private MenuModel model;

  @PostConstruct
  protected void initialize()
  {
    model = new DefaultMenuModel();

    DefaultMenuItem item = new DefaultMenuItem();
    item.setValue("Command with parameters");
    item.setCommand("#{parametrizedCommandBean.command}");
    item.setUpdate("growl");
    item.setIcon("ui-icon-play");
    item.setParam("book", "PrimeFaces with Quarkus");
    item.setParam("edition", "2026 Showcase");
    model.getElements().add(item);
  }

  public void command(MenuActionEvent event)
  {
    Map<String, List<String>> params = event.getMenuItem().getParams();
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(
      FacesMessage.SEVERITY_INFO,
      params.get("book").getFirst() + ", " +
        params.get("edition").getFirst(), null));
  }

  public MenuModel getModel()
  {
    return model;
  }
}
