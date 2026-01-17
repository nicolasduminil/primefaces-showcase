package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.model.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

@Named
@ViewScoped
public class LazyDataTableBean implements Serializable
{
  private List<Car> cars;

  private LazyDataModel<Car> lazyModel;

  public LazyDataTableBean()
  {
    this.cars = IntStream.range(0, 1000)
      .boxed()
      .flatMap(i -> CarConverter.cars.values().stream()).toList();
    this.lazyModel = new LazyCarDataModel(this.cars);
  }

  public LazyDataModel<Car> getLazyModel()
  {
    return lazyModel;
  }
}
