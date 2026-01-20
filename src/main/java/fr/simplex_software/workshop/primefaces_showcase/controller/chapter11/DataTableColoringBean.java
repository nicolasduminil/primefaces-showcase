package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter11.*;
import jakarta.annotation.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class DataTableColoringBean implements Serializable
{
  private List<CountryGdp> countryGdpList = List.of(
    new CountryGdp("United States", 16720000),
    new CountryGdp("China", 9330000),
    new CountryGdp("Japan", 5007000),
    new CountryGdp("Germany", 3593000),
    new CountryGdp("France", 2739000),
    new CountryGdp("United Kingdom", 2490000),
    new CountryGdp("Brazil", 2190000),
    new CountryGdp("Russia", 2113000)
  );

  public List<CountryGdp> getCountryGdpList()
  {
    return countryGdpList;
  }
}
