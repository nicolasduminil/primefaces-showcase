package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.enterprise.context.*;
import jakarta.inject.*;
import org.primefaces.*;
import org.primefaces.context.*;
import org.primefaces.event.*;

@Named
@RequestScoped
public class BookRatingBean
{
  private String bookName;

  public void onrate(RateEvent rateEvent)
  {
    PrimeFaces.current().dialog().closeDynamic(rateEvent.getRating());
  }

  public void oncancel()
  {
    PrimeFaces.current().dialog().closeDynamic(0);
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
