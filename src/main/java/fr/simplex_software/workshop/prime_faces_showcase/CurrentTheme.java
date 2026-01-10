package fr.simplex_software.workshop.prime_faces_showcase;

import jakarta.enterprise.context.*;
import jakarta.faces.context.*;
import jakarta.inject.*;
import jakarta.servlet.http.*;

import java.io.*;

@Named
@SessionScoped
public class CurrentTheme implements Serializable
{
  private String theme;

  public CurrentTheme()
  {
    this.theme = FacesContext.getCurrentInstance()
      .getExternalContext().getInitParameter("primefaces.THEME");
  }

  public String getTheme()
  {
    return theme;
  }

  public void setTheme(String theme)
  {
    this.theme = theme;
  }
}
