package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class PasswordBean implements Serializable
{
  private String password;

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
