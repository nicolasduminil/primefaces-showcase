package fr.simplex_software.workshop.primefaces_showcase.controller.chapter9;

import jakarta.annotation.*;
import jakarta.enterprise.context.*;
import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import software.xdev.chartjs.model.charts.*;
import software.xdev.chartjs.model.color.*;
import software.xdev.chartjs.model.data.*;
import software.xdev.chartjs.model.dataset.*;
import software.xdev.chartjs.model.options.*;
import software.xdev.chartjs.model.options.elements.*;

import java.io.*;
import java.util.*;

@Named
@SessionScoped
public class ChartBean implements Serializable
{
  private Chart lineModel;
  private Chart areaModel;
  private Chart barModel;
  private Chart pieModel;
  private Chart liveChartModel;
  private Chart combinedModel;

  @PostConstruct
  public void setup()
  {
    lineModel = createLineModel();
    areaModel = createAreaModel();
    barModel = createBarModel();
    pieModel = createPieChartModel();
    combinedModel = createCombinedModel();
  }

  private Chart createBarModel()
  {
    BarDataset sales = new BarDataset()
      .setLabel("Sales")
      .setData(List.of(1000, 1170, 660, 1030))
      .setBackgroundColor("#42A5F5");

    BarData data = new BarData()
      .addDataset(sales)
      .addLabels("2004", "2005", "2006", "2007");

    BarOptions options = new BarOptions()
      .setPlugins(new Plugins()
        .setTitle(new Title().setText("Company Performance").setDisplay(true)));

    return new BarChart().setData(data).setOptions(options);
  }

  private Chart createAreaModel()
  {
    LineDataset dataset = new LineDataset()
      .setLabel("Expenses")
      .setData(List.of(400, 460, 1120, 540))
      .setFill(true)
      .setBackgroundColor("rgba(255, 167, 38, 0.5)")
      .setBorderColor("#FFA726");

    LineData data = new LineData()
      .addDataset(dataset)
      .addLabels("2004", "2005", "2006", "2007");

    return new LineChart().setData(data);
  }


  private Chart createPieChartModel()
  {
    PieDataset dataset = new PieDataset()
      .addData(11)
      .addData(2)
      .addData(2)
      .addData(2)
      .addData(7);

    PieData data = new PieData()
      .addDataset(dataset)
      .addLabels("Work", "Eat", "Commute", "Watch TV", "Sleep");

    PieOptions options = new PieOptions()
      .setPlugins(new Plugins()
        .setLegend(new LegendOptions()
          .setPosition("left")));

    return new PieChart()
      .setData(data)
      .setOptions(options);
  }

  private Chart createLineModel()
  {
    LineDataset sales = new LineDataset()
      .setLabel("Sales")
      .setData(List.of(1000.0, 1170.0, 660.0, 1030.0))
      .setFill(false)
      .setBorderColor("#42A5F5")
      .setTension(0.1);

    LineDataset expenses = new LineDataset()
      .setLabel("Expenses")
      .setData(List.of(400.0, 460.0, 1120.0, 540.0))
      .setFill(false)
      .setBorderColor("#FFA726")
      .setTension(0.1);

    LineData data = new LineData()
      .addDataset(sales)
      .addDataset(expenses)
      .addLabels("2004", "2005", "2006", "2007");

    LineOptions options = new LineOptions()
      .setPlugins(new Plugins()
        .setTitle(new Title().setText("Company Performance").setDisplay(true)));

    return new LineChart()
      .setData(data)
      .setOptions(options);
  }

  public String getLivePieModel()
  {
    int random1 = (int) (Math.random() * 1000);
    int random2 = (int) (Math.random() * 1000);

    PieDataset dataset = new PieDataset()
      .setData(List.of((double) random1, (double) random2))
      .setBackgroundColor(List.of("#FF6384", "#36A2EB"));

    PieData data = new PieData()
      .addDataset(dataset)
      .addLabels("Candidate 1", "Candidate 2");

    PieOptions options = new PieOptions()
      .setPlugins(new Plugins()
        .setLegend(new LegendOptions().setPosition("left").setDisplay(true)));

    Chart liveChartModel = new PieChart()
      .setData(data)
      .setOptions(options);

    return liveChartModel.toJson();
  }

  public Chart createCombinedModel()
  {
    LineDataset sales = new LineDataset()
      .setType("line")
      .setLabel("Sales")
      .setData(List.of(1000.0, 1170.0, 660.0, 1030.0))
      .setBorderColor("#42A5F5")
      .setFill(false);

    BarDataset expenses = new BarDataset()
      .setType("bar")
      .setLabel("Expenses")
      .setData(List.of(400.0, 460.0, 1120.0, 540.0))
      .setBackgroundColor("#FFA726");

    MixedData data = new MixedData();

    data.addDataset(sales);
    data.addDataset(expenses);
    data.setLabels("2004", "2005", "2006", "2007");

    MixedChart combinedChart = new MixedChart()
      .setData(data)
      .setOptions(new Options<>()
        .setResponsive(true)
        .setMaintainAspectRatio(false)
        .setPlugins(new Plugins()
          .setTitle(new Title().setText("Combined Sales & Expenses")
            .setDisplay(true))));
    return combinedChart;
  }

  public String getPieModel()
  {
    return pieModel.toJson();
  }

  public String getLineModel()
  {
    return lineModel.toJson();
  }

  public String getAreaModel()
  {
    return areaModel.toJson();
  }

  public String getBarModel()
  {
    return barModel.toJson();
  }

  public String getLiveChartModel()
  {
    return liveChartModel.toJson();
  }

  public String getCombinedModel()
  {
    return combinedModel.toJson();
  }

  public void setLiveChartModel(Chart liveChartModel)
  {
    this.liveChartModel = liveChartModel;
  }

  public void setCombinedModel(Chart combinedModel)
  {
    this.combinedModel = combinedModel;
  }

  public void itemSelect(ItemSelectEvent event)
  {
    FacesContext.getCurrentInstance().addMessage(null,
      new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
      "Value: %s, Item Index: %s, DataSet Index: %s"
        .formatted(event.getData(), event.getItemIndex(), event.getDataSetIndex())));
  }
}
