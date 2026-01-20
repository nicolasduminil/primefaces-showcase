package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import jakarta.faces.event.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.*;
import org.primefaces.context.*;

import java.io.*;

@Named
@ViewScoped
public class JavaScriptExecBean implements Serializable
{

  private boolean enabled = true;

  public void toogleMenuitems(ActionEvent ae)
  {
    PrimeFaces requestContext = PrimeFaces.current();

    String script = enabled ?
      """
        $('#menu a').each(function() {
        $(this).attr('data-href', $(this).attr('href'))
        .removeAttr('href')
        .addClass('ui-state-disabled');});
        """ :
      """
        $('#menu a').each(function() {
        $(this).attr('href', $(this).attr('data-href'))
        .removeAttr('data-href')
        .removeClass('ui-state-disabled');});
        """;
    requestContext.executeScript(script);
    enabled = !enabled;
  }

  public void toogleEnabled(ActionEvent ae)
  {
    enabled = !enabled;
  }

  public boolean isEnabled()
  {
    return enabled;
  }
}
