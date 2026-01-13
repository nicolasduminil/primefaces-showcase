package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import fr.simplex_software.workshop.primefaces_showcaseconverter.CarConverter;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.Car;
import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 8/1/12
 */
@Named
@ViewScoped
public class TabViewBean implements Serializable {

    public List<Car> getCars() {
        return new ArrayList<Car>(CarConverter.cars.values());
    }

    public void onTabChange(TabChangeEvent event) {
        MessageUtil.addInfoMessage("tab.changed", "Title: " + event.getTab().getTitle());
    }

    public void onTabClose(TabCloseEvent event) {
        MessageUtil.addInfoMessage("tab.closed", "Closed Tab: " + event.getTab().getTitle());
    }
}