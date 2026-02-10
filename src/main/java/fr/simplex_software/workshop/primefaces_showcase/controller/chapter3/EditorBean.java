package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class EditorBean implements Serializable
{
  private String text;

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }
}
