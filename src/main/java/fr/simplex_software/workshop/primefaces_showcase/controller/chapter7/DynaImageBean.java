package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import jakarta.enterprise.context.*;
import jakarta.inject.*;
import org.primefaces.model.*;

import java.io.*;

@Named
@SessionScoped
public class DynaImageBean implements Serializable
{
  public StreamedContent getGraphicText()
  {
    return DefaultStreamedContent.builder()
      .stream(() -> this.getClass().getResourceAsStream("/chapter7/primefaces.jpg"))
      .build();
  }
}
