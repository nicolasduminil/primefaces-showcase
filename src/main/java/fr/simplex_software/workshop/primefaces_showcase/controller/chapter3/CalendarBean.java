package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.apache.commons.lang3.time.*;
import org.primefaces.event.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class CalendarBean implements Serializable
{
  private Date date;

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Date getYesterday()
  {
    return DateUtils.addDays(new Date(), -1);
  }

  public Date getTomorrow()
  {
    return DateUtils.addDays(new Date(), 1);
  }

  public void onDateSelect(SelectEvent event)
  {
    MessageUtil.addInfoMessage("selected.date", (Date) event.getObject());
  }
}
