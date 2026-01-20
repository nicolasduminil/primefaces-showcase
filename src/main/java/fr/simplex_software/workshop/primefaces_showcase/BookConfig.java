package fr.simplex_software.workshop.primefaces_showcase;

import io.smallrye.config.*;

import java.io.*;
import java.util.*;

@ConfigMapping(prefix = "book")
public interface BookConfig extends Serializable
{
  List<Chapter> chapters();

  interface Chapter extends Serializable
  {
    String title();
    List<Page> pages();
  }

  interface Page extends Serializable
  {
    String name();
    String view();
  }
}
