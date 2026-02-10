package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.enterprise.context.*;
import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.inject.*;

@Named
@RequestScoped
public class ExceptionHandlerBean
{
  public void throwNullPointerException()
  {
    throw new NullPointerException("NullPointerException");
  }

  public void throwIllegalStateException()
  {
    throw new IllegalStateException("IllegalStateException");
  }

  public void throwViewExpiredException()
  {
    throw new ViewExpiredException("ViewExpiredException",
      FacesContext.getCurrentInstance().getViewRoot().getViewId());
  }
}
