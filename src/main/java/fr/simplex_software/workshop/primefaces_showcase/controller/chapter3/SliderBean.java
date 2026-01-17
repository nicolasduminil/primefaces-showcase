package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;

import java.io.*;

@Named
@ViewScoped
public class SliderBean implements Serializable
{
  private int intValue = 0;
  private int rangeStart = 20;
  private int rangeEnd = 60;

  public int getIntValue()
  {
    return intValue;
  }

  public void setIntValue(int intValue)
  {
    this.intValue = intValue;
  }

  public int getRangeStart()
  {
    return rangeStart;
  }

  public void setRangeStart(int rangeStart)
  {
    this.rangeStart = rangeStart;
  }

  public int getRangeEnd()
  {
    return rangeEnd;
  }

  public void setRangeEnd(int rangeEnd)
  {
    this.rangeEnd = rangeEnd;
  }

  public void onSlideEnd(SlideEndEvent event)
  {
    MessageUtil.addInfoMessage("selected.sliderValue", event.getValue());
  }
}
