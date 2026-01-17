package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import com.lowagie.text.*;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.List;

@Named
@ViewScoped
public class DataExportBean implements Serializable
{
  private String[] selectedCountries;

  public List<String> getCountries()
  {
    return CountryList.countries;
  }

  public void preProcessPDF(Object document)
  {
    ((Document) document)
      .setFooter(new HeaderFooter(new Phrase("This is page: "), true));
  }

  public String[] getSelectedCountries()
  {
    return selectedCountries;
  }

  public void setSelectedCountries(String[] selectedCountries)
  {
    this.selectedCountries = selectedCountries;
  }
}