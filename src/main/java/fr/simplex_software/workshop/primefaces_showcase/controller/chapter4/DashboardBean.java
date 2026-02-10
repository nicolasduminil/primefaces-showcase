package fr.simplex_software.workshop.primefaces_showcase.controller.chapter4;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;
import org.primefaces.model.dashboard.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class DashboardBean implements Serializable
{
  private DashboardModel model = new DefaultDashboardModel();

  public DashboardBean()
  {
    model.addWidget(new DefaultDashboardWidget(List.of("calculator", "calendar",
      "contact", "dictionary", "translation")));
  }

  public void handleReorder(DashboardReorderEvent event)
  {
    MessageUtil.addInfoMessageWithoutKey("Reordered: %s".formatted(event.getWidgetId()),
      "Item index: %s, Column index: %s, Sender column index: "
        .formatted(event.getItemIndex(), event.getColumnIndex(), event.getSenderColumnIndex()));
  }

  public DashboardModel getModel()
  {
    return model;
  }
}
