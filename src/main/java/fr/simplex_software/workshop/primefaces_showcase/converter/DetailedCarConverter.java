package fr.simplex_software.workshop.primefaces_showcase.converter;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.*;
import jakarta.faces.component.*;
import jakarta.faces.context.*;
import jakarta.faces.convert.*;
import org.apache.commons.lang3.*;

import java.util.*;

@FacesConverter(value = "fr.simplex_software.workshop.primefaces_showcaseconverter.DetailedCarConverter")
public class DetailedCarConverter implements Converter<DetailedCar>
{
  public static Map<String, DetailedCar> cars = new HashMap<>(
    Map.of(
      "CC", new DetailedCar("CC", 2008, "black", 4),
      "Golf", new DetailedCar("Golf", 1974, "white", 2),
      "Jetta", new DetailedCar("Jetta", 1979, "blue", 5),
      "Passat", new DetailedCar("Passat", 1973, "magenta", 5),
      "Polo", new DetailedCar("Polo", 1975, "brown", 4),
      "Scirocco", new DetailedCar("Scirocco", 1974, "red", 2),
      "Touareg", new DetailedCar("Touareg", 2002, "silver", 7)
    )
  );

  @Override
  public DetailedCar getAsObject(final FacesContext fc, final UIComponent component, final String value)
  {
    return StringUtils.isBlank(value) ? null : cars.get(value);
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, DetailedCar car) throws ConverterException
  {
    return car == null ? "" : car.getName();
  }
}
