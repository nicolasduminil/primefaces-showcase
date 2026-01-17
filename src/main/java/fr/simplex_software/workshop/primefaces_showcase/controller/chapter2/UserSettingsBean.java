package fr.simplex_software.workshop.primefaces_showcase.controller.chapter2;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter2.*;
import jakarta.annotation.*;
import jakarta.enterprise.context.*;
import jakarta.inject.*;

import java.beans.*;
import java.io.*;
import java.util.*;

@Named
@SessionScoped
public class UserSettingsBean implements Serializable
{
  private final String[] THEMES =
    {
      "Afterdark",
      "Afternoon",
      "Afterwork",
      "Aristo",
      "Black-tie",
      "Blitzer",
      "Bluesky",
      "Bootstrap",
      "Casablanca",
      "Cupertino",
      "Cruze",
      "Dark-hive",
      "Delta",
      "Dot-luv",
      "Eggplant",
      "Excite-bike",
      "Flick",
      "Glass-x",
      "Home",
      "Hot-sneaks",
      "Humanity",
      "Le-frog",
      "Midnight",
      "Mint-choc",
      "Moodyblue2",
      "Overcast",
      "Pepper-grinder",
      "Redmond",
      "Rocket",
      "Sam",
      "Smoothness",
      "South-street",
      "Start",
      "Sunny",
      "Swanky-purse",
      "Trontastic",
      "Ui-darkness",
      "Ui-lightness",
      "Vader"
    };

  private Map<String, String> themes = new TreeMap<>();
  private List<Theme> availableThemes = new ArrayList<Theme>();
  private Theme theme;

  public Map<String, String> getThemes()
  {
    return themes;
  }

  public List<Theme> getAvailableThemes()
  {
    return availableThemes;
  }

  public Theme getTheme()
  {
    return theme;
  }

  public void setTheme(Theme theme)
  {
    this.theme = theme;
  }

  @PostConstruct
  public void init()
  {
    for (String th : THEMES)
      themes.put(th, Introspector.decapitalize(th));
    for (Map.Entry<String, String> theme : themes.entrySet())
      availableThemes.add(new Theme(theme.getKey(), theme.getValue()));
    theme = availableThemes.get(18);
  }
}
