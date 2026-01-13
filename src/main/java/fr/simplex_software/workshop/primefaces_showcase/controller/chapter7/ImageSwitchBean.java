package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import fr.simplex_software.workshop.primefaces_showcaseconverter.CarConverter;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 9/11/12
 */
@Named
@ViewScoped
public class ImageSwitchBean implements Serializable {

    public List<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }
}
