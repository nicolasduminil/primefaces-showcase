package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcaseconverter.CarConverter;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertcaliskan
 * on 04/01/15.
 */
@Named
@ViewScoped
public class SelectOneMenuBean implements Serializable {

    private List<Car> cars;
    private Car selectedCar;

    @PostConstruct
    public void setup() {
        cars = new ArrayList<Car>(CarConverter.cars.values());
    }

    public char getGroup(Car car) {
        return car.getName().charAt(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}