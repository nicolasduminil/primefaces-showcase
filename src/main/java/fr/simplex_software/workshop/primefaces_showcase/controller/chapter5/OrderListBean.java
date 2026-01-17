package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class OrderListBean implements Serializable
{
  private List<String> countries = List.of("England", "Germany", "Switzerland", "Turkey");

  public List<String> getCountries()
  {
    return countries;
  }

  public Collection<Car> getCars()
  {
    return new ArrayList<Car>(CarConverter.cars.values());
  }
}
