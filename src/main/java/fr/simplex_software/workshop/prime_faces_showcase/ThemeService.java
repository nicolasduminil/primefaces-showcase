package fr.simplex_software.workshop.prime_faces_showcase;

import jakarta.enterprise.context.*;
import jakarta.inject.*;

@Named
@ApplicationScoped
public class ThemeService
{
  private final String[] themes = {"afterdark",
    "afternoon",
    "afterwork",
    "aristo",
    "black-tie",
    "blitzer",
    "bluesky",
    "bootstrap",
    "casablanca",
    "cupertino",
    "cruze",
    "dark-hive",
    "delta",
    "dot-luv",
    "eggplant",
    "excite-bike",
    "flick",
    "glass-x",
    "home",
    "hot-sneaks",
    "humanity",
    "le-frog",
    "midnight",
    "mint-choc",
    "moodyblue2",
    "overcast",
    "pepper-grinder",
    "redmond",
    "rocket",
    "sam",
    "smoothness",
    "south-street",
    "start",
    "sunny",
    "swanky-purse",
    "trontastic",
    "ui-darkness",
    "ui-lightness",
    "vader"};

  public ThemeService()
  {
  }

  public String[] getThemes()
  {
    return themes;
  }
}
