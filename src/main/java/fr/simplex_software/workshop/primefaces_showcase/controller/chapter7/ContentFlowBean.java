package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class ContentFlowBean implements Serializable
{
  public List<Car> getCars()
  {
    return new ArrayList<>(CarConverter.cars.values());
  }

  public String showMessage()
  {
    MessageUtil.addInfoMessage("car.selected");
    return null;
  }
}
