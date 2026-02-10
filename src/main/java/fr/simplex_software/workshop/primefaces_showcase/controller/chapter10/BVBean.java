package fr.simplex_software.workshop.primefaces_showcase.controller.chapter10;

import jakarta.faces.view.*;
import jakarta.inject.*;
import jakarta.validation.constraints.*;

import java.io.*;
import java.math.*;
import java.util.*;

@Named(value = "bvBean")
@ViewScoped
public class BVBean implements Serializable
{
  @AssertFalse
  private boolean supported;

  @AssertTrue
  private boolean active;

  @DecimalMin("5.00")
  @DecimalMax("30.00")
  private BigDecimal discount;

  @Digits(integer = 6, fraction = 2)
  private Double price;

  @Future
  private Date eventDate;

  @Past
  private Date birthday;

  @Min(5)
  @Max(10)
  private int quantity;

  @NotNull
  private String username;

  @Null
  private String unusedString;

  @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}")
  private String phoneNumber;

  @Size(min = 2, max = 50)
  private String briefMessage;

  public boolean isSupported()
  {
    return supported;
  }

  public void setSupported(boolean supported)
  {
    this.supported = supported;
  }

  public boolean isActive()
  {
    return active;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public BigDecimal getDiscount()
  {
    return discount;
  }

  public void setDiscount(BigDecimal discount)
  {
    this.discount = discount;
  }

  public Double getPrice()
  {
    return price;
  }

  public void setPrice(Double price)
  {
    this.price = price;
  }

  public Date getEventDate()
  {
    return eventDate;
  }

  public void setEventDate(Date eventDate)
  {
    this.eventDate = eventDate;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUnusedString()
  {
    return unusedString;
  }

  public void setUnusedString(String unusedString)
  {
    this.unusedString = unusedString;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getBriefMessage()
  {
    return briefMessage;
  }

  public void setBriefMessage(String briefMessage)
  {
    this.briefMessage = briefMessage;
  }
}
