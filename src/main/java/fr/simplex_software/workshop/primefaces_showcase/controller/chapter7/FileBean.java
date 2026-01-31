package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import fr.simplex_software.workshop.primefaces_showcase.utils.*;
import jakarta.faces.application.*;
import jakarta.faces.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;
import org.primefaces.model.file.*;

import java.io.*;

@Named
@ViewScoped
public class FileBean implements Serializable
{
  private UploadedFile file;

  private UploadedFile file1;
  private UploadedFile file2;

  private final StreamedContent downloadFile;

  public FileBean()
  {
    downloadFile = DefaultStreamedContent.builder()
      .stream(() -> this.getClass().getResourceAsStream("/chapter7/PFSamplePDF.pdf"))
      .build();
  }

  public UploadedFile getFile()
  {
    System.out.println(">>> getFile(): " + file.getFileName());
    return file;
  }

  public void setFile(UploadedFile file)
  {
    System.out.println(">>> setFile: " + file.getFileName());
    this.file = file;
  }

  public UploadedFile getFile1()
  {
    return file1;
  }

  public void setFile1(UploadedFile file1)
  {
    this.file1 = file1;
  }

  public UploadedFile getFile2()
  {
    return file2;
  }

  public void setFile2(UploadedFile file2)
  {
    this.file2 = file2;
  }

  public void handleFileUpload(FileUploadEvent event)
  {
    System.out.println(">>> handleFileUpload: " + event.getFile().getFileName());
    MessageUtil.addInfoMessage("upload.successful",
      "%s is uploaded.".formatted(event.getFile().getFileName()));
  }

  public StreamedContent getDownloadFile()
  {
    return downloadFile;
  }

  public void upload()
  {
    System.out.println(">>> upload: " + (file != null ? file.getFileName() : "no file"));
    if (file != null)
      FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage("Successful",  "%s is uploaded.".formatted(file.getFileName())));
  }
}