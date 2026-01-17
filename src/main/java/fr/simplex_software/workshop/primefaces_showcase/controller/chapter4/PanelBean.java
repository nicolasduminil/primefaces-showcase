package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;

import java.io.*;

@Named
@ViewScoped
public class PanelBean implements Serializable
{
  public void handleClose(CloseEvent event)
  {
    MessageUtil.addInfoMessage("panel.closed", "Closed panel id: %s".formatted(event.getComponent().getId()));
  }

  public void handleToggle(ToggleEvent event)
  {
    MessageUtil.addInfoMessage("panel.toggled", "Status: %s".formatted(event.getVisibility().name()));
  }
}
