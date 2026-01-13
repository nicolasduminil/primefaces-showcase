package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.RateEvent;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 7/23/12
 */
@Named
@ViewScoped
public class RatingBean implements Serializable {

    private Integer rate;

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

        public void handleRate(RateEvent rateEvent) {
        Integer rate = (Integer) rateEvent.getRating();
        MessageUtil.addInfoMessage("rating.selected", rate);
    }

    public void cancelRate() {
        MessageUtil.addInfoMessage("rating.cancelled");
    }
}