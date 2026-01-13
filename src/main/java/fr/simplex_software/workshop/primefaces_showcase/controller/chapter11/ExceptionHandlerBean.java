package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.ViewExpiredException;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ExceptionHandlerBean {

    public void throwNullPointerException() {
        throw new NullPointerException("NullPointerException");
    }

    public void throwIllegalStateException() {
        throw new IllegalStateException("IllegalStateException");
    }

    public void throwViewExpiredException() {
        throw new ViewExpiredException("ViewExpiredException",
                FacesContext.getCurrentInstance().getViewRoot().getViewId());
    }
}
