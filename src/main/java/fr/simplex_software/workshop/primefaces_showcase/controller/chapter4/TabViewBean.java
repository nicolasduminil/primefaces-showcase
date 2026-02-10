package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class TabViewBean implements Serializable
{
  public List<Car> getCars()
  {
    return new ArrayList<Car>(CarConverter.cars.values());
  }

  public void onTabChange(TabChangeEvent event)
  {
    MessageUtil.addInfoMessage("tab.changed", "Title: %s".formatted(event.getTab().getTitle()));
  }

  public void onTabClose(TabCloseEvent event)
  {
    MessageUtil.addInfoMessage("tab.closed", "Closed Tab: %s".formatted(event.getTab().getTitle()));
  }
}