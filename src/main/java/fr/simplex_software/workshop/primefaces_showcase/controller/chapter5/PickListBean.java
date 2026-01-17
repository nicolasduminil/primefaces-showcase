package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

@Named
@ViewScoped
public class PickListBean implements Serializable
{
  private DualListModel<Car> cars;

  private final List<String> countriesSource = List.of("England", "Germany", "Switzerland", "Turkey");

  public PickListBean()
  {
    cars = new DualListModel<>(new ArrayList<>(CarConverter.cars.values()), new ArrayList<>());
  }

  public DualListModel<String> getCountries()
  {
    DualListModel<String> dualListModel = new DualListModel<>();
    IntStream.range(0, 250).forEach(i -> dualListModel.getSource().addAll(countriesSource));
    return dualListModel;
  }

  public DualListModel<Car> getCars()
  {
    return cars;
  }

  public void setCars(DualListModel<Car> cars)
  {
    this.cars = cars;
  }

  public void handleTransfer(TransferEvent event)
  {
    MessageUtil.addInfoMessage("items.transferred", event.getItems());
    MessageUtil.addInfoMessage("is.added", event.isAdd());
    MessageUtil.addInfoMessage("is.removed", event.isRemove());
  }
}