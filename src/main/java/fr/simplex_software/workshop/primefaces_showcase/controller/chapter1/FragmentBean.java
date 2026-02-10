package fr.simplex_software.workshop.primefaces_showcase.controller.chapter1;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;

@Named
@ViewScoped
public class FragmentBean implements Serializable
{
  private String userName;

  private String address;

  public void saveUserInfo()
  {
    System.out.println("User Info saved");
  }

  public void saveAddressInfo()
  {
    System.out.println("Address Info saved");
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }
}
