package fr.simplex_software.workshop.primefaces_showcase.model.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import jakarta.faces.model.*;
import org.primefaces.model.*;

import java.util.*;

public class CarDataModel extends ListDataModel<Car> implements SelectableDataModel<Car>
{
  public CarDataModel (List<Car> cars)
  {
    super(cars);
  }

  @Override
  public Car getRowData(String rowKey)
  {
    return ((List<Car>) getWrappedData()).stream()
      .filter(car -> car.getName().equals(rowKey))
      .findFirst()
      .orElse(null);
  }

  @Override
  public String getRowKey(Car car)
  {
    return car.getName();
  }
}