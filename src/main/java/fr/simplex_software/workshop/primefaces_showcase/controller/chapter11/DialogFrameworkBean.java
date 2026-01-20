package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.*;
import org.primefaces.event.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class DialogFrameworkBean implements Serializable
{

  private String bookName;

  public void showRatingDialog()
  {
    Map<String, Object> options = Map.of(
      "modal", true,
      "draggable", false,
      "resizable", false,
      "contentWidth", 500,
      "contentHeight", 100,
      "includeViewParams", true);
    Map<String, List<String>> params = new HashMap<String, List<String>>();
    List<String> values = List.of(bookName);
    params.put("bookName", values);

    PrimeFaces.current().dialog().openDynamic("/views/chapter11/bookRating", options, params);
  }

  public void onDialogReturn(SelectEvent event)
  {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
      FacesMessage.SEVERITY_INFO,
      "You rated the book with %s".formatted(event.getObject()),
      null));
  }

  public String getBookName()
  {
    return bookName;
  }

  public void setBookName(String bookName)
  {
    this.bookName = bookName;
  }
}
