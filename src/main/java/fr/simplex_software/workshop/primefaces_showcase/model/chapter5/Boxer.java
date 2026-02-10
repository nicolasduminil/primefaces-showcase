package fr.simplex_software.workshop.primefaces_showcase.model.chapter5;

import java.io.*;
import java.util.*;

public class Boxer implements Serializable
{
  private String name;
  private List<Stat> stats = new ArrayList<Stat>();

  public Boxer(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<Stat> getStats()
  {
    return stats;
  }

  public void setStats(List<Stat> stats)
  {
    this.stats = stats;
  }

  public int getAllWins()
  {
    return stats.stream()
      .mapToInt(Stat::getWin)
      .sum();
  }

  public int getAllLosses()
  {
    return stats.stream()
      .mapToInt(Stat::getLoss)
      .sum();
  }
}
