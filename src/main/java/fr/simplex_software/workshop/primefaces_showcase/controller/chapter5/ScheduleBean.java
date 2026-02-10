package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.annotation.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.event.schedule.*;
import org.primefaces.model.*;

import java.io.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

@Named
@ViewScoped
public class ScheduleBean implements Serializable
{
  private ScheduleModel lazyEventModel;

  @PostConstruct
  public void initialize()
  {
    lazyEventModel = new LazyScheduleModel()
    {
      @Override
      public void loadEvents(LocalDateTime start, LocalDateTime end)
      {
        try
        {
          Thread.sleep(1500);
        }
        catch (Exception ignored)
        {
        }

        clear();

        IntStream.rangeClosed(1, 2).forEach(i ->
        {
          LocalDateTime random = getRandomDate(start);
          addEvent(DefaultScheduleEvent.builder()
            .title("Lazy Event " + i)
            .startDate(random)
            .endDate(random)
            .build());
        });
      }
    };
  }

  public ScheduleModel getLazyScheduleModel()
  {
    return lazyEventModel;
  }

  public LocalDateTime getRandomDate(LocalDateTime base)
  {
    return base.plusDays(new Random().nextInt(30) + 1);
  }


  public void onDateSelect(SelectEvent<?> event)
  {
    MessageUtil.addInfoMessage("date.selected", event.getObject());
  }

  public void onEventSelect(SelectEvent<?> event)
  {
    MessageUtil.addInfoMessage("event.selected", ((DefaultScheduleEvent<?>) event.getObject()).getTitle());
  }

  public void onEventMove(ScheduleEntryMoveEvent event)
  {
    MessageUtil.addInfoMessage("event.moved", event.getScheduleEvent().getTitle(), event.getDayDelta(), event.getMinuteDelta());
  }

  public void onEventResize(ScheduleEntryResizeEvent event)
  {
    MessageUtil.addInfoMessage("event.resized", event.getScheduleEvent().getTitle(),
      event.getDayDeltaStart(), event.getMinuteDeltaStart());
  }

  public void onViewChange(SelectEvent<?> event)
  {
    MessageUtil.addInfoMessage("view.changed", event.getObject());
  }
}
