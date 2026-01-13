package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import fr.simplex_software.workshop.primefaces_showcaseconverter.CarConverter;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;
import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertcaliskan
 * on 25/01/15.
 */
@Named
@ViewScoped
public class ContentFlowBean implements Serializable {

    public List<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }

    public String showMessage() {
        MessageUtil.addInfoMessage("car.selected");
        return null;
    }
}
