package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.annotation.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.model.menu.*;

import java.io.*;


@Named
@ViewScoped
public class ProgrammaticMenuBean implements Serializable
{
  private MenuModel model;

  @PostConstruct
  protected void initialize()
  {
    model = new DefaultMenuModel();

    DefaultSubMenu submenu = new DefaultSubMenu();
    submenu.setLabel("JavaScript Libraries");

    DefaultMenuItem item = new DefaultMenuItem();
    item.setValue("jQuery");
    item.setUrl("http://jquery.com");
    submenu.getElements().add(item);

    item = new DefaultMenuItem();
    item.setValue("Yahoo UI");
    item.setUrl("http://yuilibrary.com");
    submenu.getElements().add(item);

    item = new DefaultMenuItem();
    item.setValue("Prototype");
    item.setUrl("http://prototypejs.org");
    submenu.getElements().add(item);

    model.getElements().add(submenu);

    submenu = new DefaultSubMenu();
    submenu.setLabel("Operations");

    item = new DefaultMenuItem();
    item.setValue("Save");
    item.setCommand("#{positionedMenuBean.save}");
    item.setUpdate("growl");
    submenu.getElements().add(item);

    item = new DefaultMenuItem();
    item.setValue("Update");
    item.setCommand("#{positionedMenuBean.update}");
    item.setUpdate("growl");
    submenu.getElements().add(item);

    item = new DefaultMenuItem();
    item.setValue("Delete");
    item.setCommand("#{positionedMenuBean.delete}");
    item.setUpdate("growl");
    submenu.getElements().add(item);

    model.getElements().add(submenu);
  }

  public MenuModel getModel()
  {
    return model;
  }
}
