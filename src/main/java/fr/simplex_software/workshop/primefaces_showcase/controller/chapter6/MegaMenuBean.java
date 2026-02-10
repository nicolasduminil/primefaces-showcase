package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class MegaMenuBean implements Serializable
{
  private List<String> items = new ArrayList<>();

  public String getItems()
  {
    return "Bought items: %s".formatted(String.join(", ", items));
  }

  public void addItem(String item)
  {
    items.add(item);
  }
}
