package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.SlideEndEvent;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 7/1/12
 */
@Named
@ViewScoped
public class SliderBean implements Serializable {

    private int intValue = 0;
    private int rangeStart = 20;
    private int rangeEnd = 60;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public void onSlideEnd(SlideEndEvent event) {
        int value = event.getValue();
        MessageUtil.addInfoMessage("selected.sliderValue", value);
    }
}
