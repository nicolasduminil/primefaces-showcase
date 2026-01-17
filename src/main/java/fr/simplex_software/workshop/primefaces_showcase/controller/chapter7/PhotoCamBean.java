package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import jakarta.enterprise.context.*;
import jakarta.inject.*;
import org.primefaces.event.*;
import org.primefaces.model.*;

import java.io.*;

@Named
@SessionScoped
public class PhotoCamBean implements Serializable
{
  private StreamedContent capturedImage;

  public StreamedContent getCapturedImage()
  {
    return capturedImage;
  }

  public void setCapturedImage(StreamedContent capturedImage)
  {
    this.capturedImage = capturedImage;
  }

  public void onCapture(CaptureEvent captureEvent)
  {
    byte[] data = captureEvent.getData();
    capturedImage = DefaultStreamedContent.builder()
      .stream(() -> new ByteArrayInputStream(data))
      .build();
  }
}