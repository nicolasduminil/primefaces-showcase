package fr.simplex_software.workshop.primefaces_showcase.controller.chapter8;

import fr.simplex_software.workshop.primefaces_showcase.model.chapter8.*;
import jakarta.annotation.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;

import java.io.*;
import java.time.*;
import java.util.*;

@Named
@ViewScoped
public class IntegrationDragDrop implements Serializable
{
  private final List<Document> availableDocs = new ArrayList<>(List.of (
    new Document("Perl script", 120, "Sara Schmidt", getCreationDate(), "perl"),
    new Document("Alex's master thesis", 850, "Alex Konradi", getCreationDate(), "dvi"),
    new Document("jQuery presentation", 687, "Jasper Morgan", getCreationDate(), "ppt"),
    new Document("Russian songs", 1020, "Urmel Night", getCreationDate(), "mid"),
    new Document("German songs", 2268, "Nicole Konradi", getCreationDate(), "mp3"),
    new Document("Cool flash multimedia", 2268, "John Wiese", getCreationDate(), "swf"),
    new Document("Windows custom sound", 84, "Sebastian Schwarz", getCreationDate(), "wav"),
    new Document("Currency exchange table", 1400, "Nadja Swift", getCreationDate(), "xls"),
    new Document("Search masks configuration", 33, "Andrew Andreev", getCreationDate(), "xml")
  ));
  private final List<Document> deletedDocs = new ArrayList<>();

   public List<Document> getAvailableDocs()
  {
    return availableDocs;
  }

  public List<Document> getDeletedDocs()
  {
    return deletedDocs;
  }

  public void onDocumentDrop(DragDropEvent<Document> ddEvent)
  {
    Document doc = ddEvent.getData();
    deletedDocs.add(doc);
    availableDocs.remove(doc);
  }

  private Date getCreationDate()
  {
    Random random = new Random();
    int day = random.nextInt(1, 29);
    int month = random.nextInt(1, 13);
    LocalDate localDate = LocalDate.of(2026, month, day);
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }
}
