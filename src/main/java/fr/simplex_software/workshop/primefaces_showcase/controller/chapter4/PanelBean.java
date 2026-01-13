package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 8/4/12
 */
@Named
@ViewScoped
public class PanelBean implements Serializable {

    public void handleClose(CloseEvent event) {
        MessageUtil.addInfoMessage("panel.closed", "Closed panel id:'" + event.getComponent().getId());
    }

    public void handleToggle(ToggleEvent event) {
        MessageUtil.addInfoMessage("panel.toggled", "Status:" + event.getVisibility().name());
    }
}
