package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.*;
import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.annotation.*;
import jakarta.faces.event.*;
import jakarta.faces.model.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.component.datatable.*;
import org.primefaces.event.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

@Named
@ViewScoped
public class DataTableBean implements Serializable
{
  private List<Car> cars = new ArrayList<Car>(CarConverter.cars.values());
  private List<DetailedCar> detailedCars = new ArrayList<DetailedCar>(DetailedCarConverter.cars.values());
  private Car selectedCar;
  private Car[] selectedCars;
  private SelectItem[] carNamesOptions;
  private List<Car> filteredValues;
  private CarDataModel carDataModel = new CarDataModel(cars);
  private List<Boxer> boxers;

  @PostConstruct
  public void setup()
  {
    boxers = List.of(
      createBoxer("Muhammad Ali", List.of(
        new Stat("2005-2006", 7, 5),
        new Stat("2006-2007", 10, 5),
        new Stat("2007-2008", 3, 8),
        new Stat("2008-2009", 10, 4),
        new Stat("2009-2010", 10, 5),
        new Stat("2010-2011", 3, 10)
      )),
      createBoxer("George Foreman", List.of(
        new Stat("2005-2006", 4, 10),
        new Stat("2006-2007", 6, 8),
        new Stat("2007-2008", 10, 5),
        new Stat("2008-2009", 7, 6),
        new Stat("2009-2010", 10, 8),
        new Stat("2010-2011", 7, 4)
      ))
    );
  }

  public void onResize(ColumnResizeEvent event)
  {
    MessageUtil.addInfoMessage("column.resized", "W: %d - H: %d"
      .formatted(event.getWidth(), event.getHeight()));
  }

  public void onRowReorder(ReorderEvent event)
  {
    MessageUtil.addInfoMessage("row.reordered", "From: %d - To: %d"
      .formatted(event.getFromIndex(), event.getToIndex()));
  }

  public void onColReorder(AjaxBehaviorEvent event)
  {
    MessageUtil.addInfoMessage("col.reordered", "Component ID: %s".formatted(event.getComponent().getId()));
  }

  public void onColumnToggle(ToggleEvent e)
  {
    MessageUtil.addInfoMessage("col.toggled", "Visibility: %s".formatted(e.getVisibility()));
  }

  public String[] getCarNames()
  {
    return CarConverter.cars.keySet().toArray(new String[0]);
  }

  public SelectItem[] getCarNamesAsOptions()
  {
    return createFilterOptions(CarConverter.cars.keySet().toArray(new String[0]));
  }

  private SelectItem[] createFilterOptions(String[] data)
  {
    return IntStream.range(0, data.length)
      .mapToObj(i -> new SelectItem(data[i], data[i]))
      .toArray(SelectItem[]::new);
  }

  public void selectCar(Car car)
  {
    this.selectedCar = car;
  }

  public void onRowSelect(SelectEvent event)
  {
    MessageUtil.addInfoMessage("car.selected", ((Car) event.getObject()).getName());
  }

  public void onRowUnselect(UnselectEvent event)
  {
    MessageUtil.addInfoMessage("car.unselected", ((Car) event.getObject()).getName());
  }

  public void onEdit(RowEditEvent event)
  {
    MessageUtil.addInfoMessage("car.edit", ((Car) event.getObject()).getName());
  }

  public void onCancel(RowEditEvent event)
  {
    MessageUtil.addInfoMessage("car.edit.cancelled", ((Car) event.getObject()).getName());
  }

  public void postSort(ComponentSystemEvent e)
  {
    ((DataTable) e.getComponent()).getSortByAsMap().keySet()
      .forEach(key -> System.out.println(key));
  }

  public void postFilter(ComponentSystemEvent e)
  {
    Optional.ofNullable(((DataTable) e.getComponent()).getFilteredValue())
      .map(val -> (List<Car>) val)
      .ifPresent(list -> list.forEach(car -> System.out.println(car.getName())));
  }

  public Car getSelectedCar()
  {
    return selectedCar;
  }

  public void setSelectedCar(Car selectedCar)
  {
    this.selectedCar = selectedCar;
  }

  public Car[] getSelectedCars()
  {
    return selectedCars;
  }

  public void setSelectedCars(Car[] selectedCars)
  {
    this.selectedCars = selectedCars;
  }

  public List<Car> getCars()
  {
    return cars;
  }

  public void setCars(List<Car> cars)
  {
    this.cars = cars;
  }

  public List<Car> getFilteredValues()
  {
    return filteredValues;
  }

  public void setFilteredValues(List<Car> filteredValues)
  {
    this.filteredValues = filteredValues;
  }

  public CarDataModel getCarDataModel()
  {
    return carDataModel;
  }

  public void setCarDataModel(CarDataModel carDataModel)
  {
    this.carDataModel = carDataModel;
  }

  public List<DetailedCar> getDetailedCars()
  {
    return detailedCars;
  }

  public void setDetailedCars(List<DetailedCar> detailedCars)
  {
    this.detailedCars = detailedCars;
  }

  public List<Boxer> getBoxers()
  {
    return boxers;
  }

  public void setBoxers(List<Boxer> boxers)
  {
    this.boxers = boxers;
  }

  private Boxer createBoxer(String name, List<Stat> stats)
  {
    Boxer b = new Boxer(name);
    b.getStats().addAll(stats);
    return b;
  }
}
