package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class GalleriaBean implements Serializable
{
  public List<Car> getCars()
  {
    return new ArrayList<Car>(CarConverter.cars.values());
  }
}
