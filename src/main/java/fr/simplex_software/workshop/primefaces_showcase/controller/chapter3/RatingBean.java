package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;

import java.io.*;

@Named
@ViewScoped
public class RatingBean implements Serializable
{
  private Integer rate;

  public Integer getRate()
  {
    return rate;
  }

  public void setRate(Integer rate)
  {
    this.rate = rate;
  }

  public void handleRate(RateEvent rateEvent)
  {
    MessageUtil.addInfoMessage("rating.selected", rateEvent.getRating());
  }

  public void cancelRate()
  {
    MessageUtil.addInfoMessage("rating.cancelled");
  }
}