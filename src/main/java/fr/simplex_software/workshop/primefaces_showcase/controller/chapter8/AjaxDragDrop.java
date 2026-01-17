package fr.simplex_software.workshop.primefaces_showcase.controller.chapter8;

import jakarta.faces.application.*;
import jakarta.faces.component.*;
import jakarta.faces.component.html.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.component.datalist.*;
import org.primefaces.event.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class AjaxDragDrop implements Serializable
{
  private final List<String> orderedPizza = new ArrayList<>();
  private final List<String> removedPizza = new ArrayList<>();

  public List<String> getOrderedPizza()
  {
    return orderedPizza;
  }

  public List<String> getRemovedPizza()
  {
    return removedPizza;
  }

  public void onPizzaOrder(DragDropEvent<String> event)
  {
    HtmlGraphicImage image = (HtmlGraphicImage) event.
      getComponent().findComponent(event.getDragId());
    String pizza = image != null ? image.getTitle() : "";

    orderedPizza.add(pizza);

    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO,
      "Selected pizza: " + pizza, null));
  }

  public void onPizzaRemove(DragDropEvent<String> event)
  {
    DataList dataList = (DataList) event.
      getComponent().findComponent("orderedPizza");

    FacesContext fc = FacesContext.getCurrentInstance();
    dataList.invokeOnComponent(fc, event.getDragId(),
      (fc1, comp) ->
      {
        HtmlPanelGroup pGroup = (HtmlPanelGroup) comp;
        String pizza = pGroup != null ?
          (String) pGroup.getAttributes().get("pizza") :
          "";

        orderedPizza.remove(pizza);
        removedPizza.add(pizza);

        FacesMessage msg = new FacesMessage(
          FacesMessage.SEVERITY_INFO,
          "Removed pizza: " + pizza, null);
        fc1.addMessage(null, msg);
      });
  }

  public String sendOrder()
  {
    StringBuilder sb = new StringBuilder("You have ordered:");
    for (String pizza : orderedPizza)
    {
      sb.append("<br/>");
      sb.append(pizza);
    }

    FacesMessage msg = new FacesMessage(
      FacesMessage.SEVERITY_INFO, sb.toString(), null);
    FacesContext.getCurrentInstance().addMessage(null, msg);

    return null;
  }
}
