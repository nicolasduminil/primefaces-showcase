package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class ScrollPanelBean implements Serializable
{
  public List<Car> getCars()
  {
    return new ArrayList<Car>(CarConverter.cars.values());
  }
}
