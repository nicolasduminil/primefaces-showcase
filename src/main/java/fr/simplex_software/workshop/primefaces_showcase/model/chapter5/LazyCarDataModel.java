package fr.simplex_software.workshop.primefaces_showcase.model.chapter5;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter3.*;
import org.primefaces.model.*;

import java.util.*;
import java.util.stream.*;

public class LazyCarDataModel extends LazyDataModel<Car>
{
  private final List<Car> datasource;

  public LazyCarDataModel(List<Car> datasource)
  {
    this.datasource = datasource;
  }

  @Override
  public int count(Map<String, FilterMeta> filters)
  {
    return (int) datasource.stream()
      .filter(car -> filter(car, filters))
      .count();
  }

  @Override
  public List<Car> load(int first, int pageSize, Map<String, SortMeta> sortOrder, Map<String, FilterMeta> filters)
  {
    List<Car> data = datasource.stream()
      .filter(car -> filter(car, filters))
      .collect(Collectors.toList());

    if (sortOrder != null && !sortOrder.isEmpty())
    {
      data.sort((car1, car2) ->
      {
        for (SortMeta meta : sortOrder.values())
        {
          try
          {
            @SuppressWarnings("unchecked")
            Comparable<Object> value1 = (Comparable<Object>) car1.getClass().getField(meta.getField()).get(car1);
            @SuppressWarnings("unchecked")
            Comparable<Object> value2 = (Comparable<Object>) car2.getClass().getField(meta.getField()).get(car2);
            int result = value1.compareTo(value2);
            if (result != 0)
            {
              return meta.getOrder() == SortOrder.ASCENDING ? result : -result;
            }
          }
          catch (Exception e)
          {
            throw new RuntimeException(e);
          }
        }
        return 0;
      });
    }

    return data.stream()
      .skip(first)
      .limit(pageSize)
      .toList();
  }

  @Override
  public Car getRowData(String rowKey)
  {
    return datasource.stream()
      .filter(car -> car.getName().equals(rowKey))
      .findFirst()
      .orElse(null);
  }

  @Override
  public String getRowKey(Car car)
  {
    return car.getName();
  }

  private boolean filter(Car car, Map<String, FilterMeta> filters)
  {
    return filters.values().stream().allMatch(meta ->
    {
      boolean ret = true;
      try
      {
        Object filterValue = meta.getFilterValue();
        if (filterValue != null)
          ret = String.valueOf(car.getClass().getField(meta.getField()).get(car))
            .toLowerCase().startsWith(String.valueOf(filterValue).toLowerCase());
      }
      catch (Exception e)
      {
        ret = false;
      }
      return ret;
    });
  }
}
