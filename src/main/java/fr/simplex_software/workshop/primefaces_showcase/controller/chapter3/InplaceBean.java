package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.event.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class InplaceBean implements Serializable
{
  private boolean value;

  public boolean isValue()
  {
    return value;
  }

  public void setValue(boolean value)
  {
    this.value = value;
  }

  public void handleSave(AjaxBehaviorEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Input Saved!", null);
  }
}

