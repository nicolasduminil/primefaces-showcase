package fr.simplex_software.workshop.primefaces_showcase.controller.chapter10;

import fr.simplex_software.workshop.primefaces_showcase.validator.*;
import io.quarkus.runtime.annotations.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import jakarta.validation.constraints.*;
import org.primefaces.*;
import org.primefaces.context.*;

import java.io.*;

@Named
@ViewScoped
@RegisterForReflection
public class ExtendCsvBean implements Serializable
{
  private String firstName;
  private String lastName;

  @NotNull
  private String card;
  @NotNull
  @ValidCVC(forCardMenu = "@@(#cbv)")
  private String cvc;

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

  public String getCvc()
  {
    return cvc;
  }

  public void setCvc(String cvc)
  {
    this.cvc = cvc;
  }

  public void save()
  {
    PrimeFaces.current().executeScript("alert('Saved!')");
  }
}
