package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcaseconverter.CarConverter;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.CountryList;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 8/19/12
 */
@Named
@ViewScoped
public class DataListBean implements Serializable {

    public Collection<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }

    public List<String> getCountriesShort() {
        return CountryList.countriesShort;
    }

    public List<String> getCountries() {
        return CountryList.countries;
    }

    public int getCountriesSize() {
        return getCountries().size();
    }
}