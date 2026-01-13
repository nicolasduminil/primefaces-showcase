package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * User: mertcaliskan
 * Date: 7/19/12
 */
@Named
@ViewScoped
public class PasswordBean implements Serializable {
    
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
