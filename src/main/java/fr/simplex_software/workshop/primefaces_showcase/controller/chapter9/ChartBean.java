package fr.simplex_software.workshop.primefaces_showcase.controller.chapter9;

import jakarta.annotation.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import software.xdev.chartjs.model.charts.*;
import software.xdev.chartjs.model.data.*;
import software.xdev.chartjs.model.dataset.*;
import software.xdev.chartjs.model.options.*;

import java.io.*;
import java.util.*;

/**
 * User: mertcaliskan
 * Date: 9/18/12
 */
@Named
@ViewScoped
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
      .setTension(0.1); // Optional: smooths the line

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

  public String getCombinedModel()
  {
    LineDataset sales = new LineDataset()
      .setLabel("Sales")
      .setData(List.of(1000.0, 1170.0, 660.0, 1030.0))
      .setBorderColor("#42A5F5")
      .setFill(false);

    BarDataset expenses = new BarDataset()
      .setLabel("Expenses")
      .setData(List.of(400.0, 460.0, 1120.0, 540.0))
      .setBackgroundColor("#FFA726");

    BarData data = new BarData()
      .addLabels("2004", "2005", "2006", "2007");

    ((List) data.getDatasets()).add(sales);
    data.addDataset(expenses);

    BarChart combinedChart = new BarChart()
      .setData(data)
      .setOptions(new BarOptions()
        .setPlugins(new Plugins()
          .setTitle(new Title().setText("Combined Sales & Expenses").setDisplay(true))));

    return combinedChart.toJson();
  }

  public Chart getPieModel()
  {
    return pieModel;
  }

  public Chart getLineModel()
  {
    return lineModel;
  }

  public Chart getAreaModel()
  {
    return areaModel;
  }

  public Chart getBarModel()
  {
    return barModel;
  }

  public Chart getLiveChartModel()
  {
    return liveChartModel;
  }

  public void setLiveChartModel(Chart liveChartModel)
  {
    this.liveChartModel = liveChartModel;
  }

  public void setCombinedModel(Chart combinedModel)
  {
    this.combinedModel = combinedModel;
  }
}
