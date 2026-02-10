package fr.simplex_software.workshop.primefaces_showcase.utils;

import jakarta.faces.application.*;
import jakarta.faces.context.*;

import java.text.*;
import java.util.*;

public class MessageUtil
{
  public static void addInfoMessage(String str)
  {
    FacesContext context = FacesContext.getCurrentInstance();
    ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
    String message = bundle.getString(str);
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
  }

  public static void addInfoMessage(String summary, String detail)
  {
    FacesContext context = FacesContext.getCurrentInstance();
    ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
      bundle.getString(summary), detail));
  }

  public static void addInfoMessage(String str, Object... args)
  {
    FacesContext context = FacesContext.getCurrentInstance();
    ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
    String message = bundle.getString(str);
    if (args != null)
      message = MessageFormat.format(message, args);
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
  }

  public static void addInfoMessageWithoutKey(String summary, String detail)
  {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
  }

  public static String getMessage(String key, Object... args)
  {
    FacesContext context = FacesContext.getCurrentInstance();
    ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
    String message = bundle.getString(key);
    if (args != null)
      message = MessageFormat.format(message, args);

    return message;
  }
}
