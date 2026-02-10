package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.*;
import fr.simplex_software.workshop.primefaces_showcase.converter.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class DataListBean implements Serializable
{
  public Collection<Car> getCars()
  {
    return new ArrayList<Car>(CarConverter.cars.values());
  }

  public List<String> getCountriesShort()
  {
    return CountryList.countriesShort;
  }

  public List<String> getCountries()
  {
    return CountryList.countries;
  }

  public int getCountriesSize()
  {
    return getCountries().size();
  }
}