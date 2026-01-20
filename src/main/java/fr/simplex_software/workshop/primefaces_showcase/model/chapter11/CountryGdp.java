package fr.simplex_software.workshop.primefaces_showcase.model.chapter11;

import java.io.*;

public class CountryGdp implements Serializable
{
  private String name;
  private long gdp;

  public CountryGdp()
  {
  }

  public CountryGdp(String name, long gdp)
  {
    this.name = name;
    this.gdp = gdp;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public long getGdp()
  {
    return gdp;
  }

  public void setGdp(long gdp)
  {
    this.gdp = gdp;
  }
}


