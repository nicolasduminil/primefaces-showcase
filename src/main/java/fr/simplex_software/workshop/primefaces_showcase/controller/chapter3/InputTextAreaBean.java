package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

@Named
@ViewScoped
public class InputTextAreaBean implements Serializable
{
  private String value;

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public List<String> complete(String query)
  {
    return query.equals("PrimeFaces") ? List.of("PrimeFaces Rocks!!!",
      "PrimeFaces has 100+ components.",
      "PrimeFaces is lightweight.",
      "PrimeFaces Cookbook is the best source for PrimeFaces !") :
      IntStream.range(0, 10).mapToObj(i -> query + i).collect(Collectors.toList());
  }
}
