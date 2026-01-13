package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import org.primefaces.component.layout.LayoutUnit;
import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.ToggleEvent;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 8/6/12
 */
@Named
@ViewScoped
public class LayoutBean implements Serializable {

    public void handleClose(CloseEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Unit Closed", "Position:'" + ((LayoutUnit) event.getComponent()).getPosition());
    }

    public void handleToggle(ToggleEvent event) {
        MessageUtil.addInfoMessageWithoutKey(((LayoutUnit)event.getComponent()).getPosition() + " toggled", "Status:" + event.getVisibility().name());
    }

    public void handleResize(ResizeEvent event) {
        MessageUtil.addInfoMessageWithoutKey(((LayoutUnit)event.getComponent()).getPosition() + " resized", "Status:" + event.getComponent().getId());
    }
}
