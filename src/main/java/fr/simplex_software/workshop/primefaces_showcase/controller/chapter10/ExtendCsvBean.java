package fr.simplex_software.workshop.primefaces_showcase.controller.chapter10;

import fr.simplex_software.workshop.primefaces_showcase.validator.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import jakarta.validation.constraints.*;
import org.primefaces.*;
import org.primefaces.context.*;

import java.io.*;

@Named
@ViewScoped
public class ExtendCsvBean implements Serializable
{
  private String firstName;
  private String lastName;

  @NotNull
  private String card;
  @NotNull
  @ValidCVC(forCardMenu = "@(.card)")
  private Integer cvc;

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getCard()
  {
    return card;
  }

  public void setCard(String card)
  {
    this.card = card;
  }

  public Integer getCvc()
  {
    return cvc;
  }

  public void setCvc(Integer cvc)
  {
    this.cvc = cvc;
  }

  public void save()
  {
    PrimeFaces.current().executeScript("alert('Saved!')");
  }
}
