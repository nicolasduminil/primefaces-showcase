package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.annotation.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class SelectOneMenuBean implements Serializable
{
  private List<Car> cars;
  private Car selectedCar;

  @PostConstruct
  public void setup()
  {
    cars = new ArrayList<Car>(CarConverter.cars.values());
  }

  public char getGroup(Car car)
  {
    return car.getName().charAt(0);
  }

  public List<Car> getCars()
  {
    return cars;
  }

  public void setCars(List<Car> cars)
  {
    this.cars = cars;
  }

  public Car getSelectedCar()
  {
    return selectedCar;
  }

  public void setSelectedCar(Car selectedCar)
  {
    this.selectedCar = selectedCar;
  }
}