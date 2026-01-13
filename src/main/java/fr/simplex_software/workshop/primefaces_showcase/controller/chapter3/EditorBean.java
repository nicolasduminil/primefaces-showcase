package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 6/30/12
 */
@Named
@ViewScoped
public class EditorBean implements Serializable {
    
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
