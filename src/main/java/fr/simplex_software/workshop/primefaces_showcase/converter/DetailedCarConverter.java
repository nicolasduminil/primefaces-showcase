package fr.simplex_software.workshop.primefaces_showcaseconverter;

/**
 * User: mertcaliskan
 * Date: 7/9/12
 */

import org.apache.commons.lang3.StringUtils;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.DetailedCar;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

@FacesConverter(value = "fr.simplex_software.workshop.primefaces_showcaseconverter.DetailedCarConverter")
public class DetailedCarConverter implements Converter {

    public static Map<String, DetailedCar> cars = new HashMap<String, DetailedCar>();

    static {
        cars.put("CC", new DetailedCar("CC", 2008, "black", 4));
        cars.put("Golf", new DetailedCar("Golf", 1974, "white", 2));
        cars.put("Jetta", new DetailedCar("Jetta", 1979, "blue", 5));
        cars.put("Passat", new DetailedCar("Passat", 1973, "magenta", 5));
        cars.put("Polo", new DetailedCar("Polo", 1975, "brown", 4));
        cars.put("Scirocco", new DetailedCar("Scirocco", 1974, "red", 2));
        cars.put("Touareg", new DetailedCar("Touareg", 2002, "silver", 7));
    }
    
    public Object getAsObject(final FacesContext fc, final UIComponent component, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        else {
            return cars.get(value);
        }
    }

    public String getAsString(final FacesContext fc, final UIComponent component, final Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((DetailedCar) value).getName());
        }
    }
}
