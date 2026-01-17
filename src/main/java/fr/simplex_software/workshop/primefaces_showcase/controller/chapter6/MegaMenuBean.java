package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class MegaMenuBean implements Serializable
{
  public String getItems()
  {
    return "Bought items: ...";
  }
}
