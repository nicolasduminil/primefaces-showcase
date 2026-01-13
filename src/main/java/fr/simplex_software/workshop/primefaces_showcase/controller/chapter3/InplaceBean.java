package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import org.primefaces.component.layout.LayoutUnit;
import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;

import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * Created by mertcaliskan
 * on 03/01/15.
 */
@Named
@ViewScoped
public class InplaceBean implements Serializable {
    private boolean value;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void handleSave(AjaxBehaviorEvent event) {
        MessageUtil.addInfoMessageWithoutKey("Input Saved!", null);
    }
}

