package fr.simplex_software.workshop.primefaces_showcase.converter;

import jakarta.faces.convert.*;
import org.apache.commons.lang3.StringUtils;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;

import java.util.*;

@FacesConverter(value = "fr.simplex_software.workshop.primefaces_showcase.converter.CarConverter")
public class CarConverter implements Converter<Car>
{
  public static Map<String, Car> cars = Map.of(
    "CC", new Car("CC", 2008),
    "Golf", new Car("Golf", 1974),
    "Jetta", new Car("Jetta", 1979),
    "Passat", new Car("Passat", 1973),
    "Polo", new Car("Polo", 1975),
    "Scirocco", new Car("Scirocco", 1974),
    "Touareg", new Car("Touareg", 2002)
  );

  public Car getAsObject(final FacesContext fc, final UIComponent component, final String value)
  {
    return StringUtils.isBlank(value) ? null : cars.get(value);
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, Car car) throws ConverterException
  {
    return car == null ? "" : car.getName();
  }
}
