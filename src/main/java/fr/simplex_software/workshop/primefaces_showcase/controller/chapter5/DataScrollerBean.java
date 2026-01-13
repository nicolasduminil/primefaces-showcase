package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcaseconverter.CarConverter;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * User: mertcaliskan
 * Date: 8/21/12
 */
@Named
@ViewScoped
public class DataScrollerBean implements Serializable {

    public Collection<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }
}