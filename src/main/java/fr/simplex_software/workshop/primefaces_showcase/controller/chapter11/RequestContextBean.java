package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.event.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.*;

import java.io.*;

@Named
@ViewScoped
public class RequestContextBean implements Serializable
{
  private boolean firstOutput = true;

  private int counter = 0;

  public void incrementWithUpdate()
  {
    counter++;
    PrimeFaces.current().ajax().update(firstOutput ? "firstOutput" : "secondOutput");
  }

  public void incrementWithScroll()
  {
    counter++;
    PrimeFaces.current().scrollTo("counter");
  }

  public boolean isFirstOutput()
  {
    return firstOutput;
  }

  public void setFirstOutput(boolean firstOutput)
  {
    this.firstOutput = firstOutput;
  }

  public int getCounter()
  {
    return counter;
  }
}
