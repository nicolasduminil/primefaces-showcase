package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import jakarta.enterprise.context.*;
import jakarta.inject.*;
import org.primefaces.model.*;

import java.io.*;

@Named
@SessionScoped
public class ImageCropBean implements Serializable
{
  private CroppedImage croppedImageSimple;
  private CroppedImage croppedImageCoordinates;
  private CroppedImage croppedImageAspectRatio;
  private CroppedImage croppedImageMinMaxSize;

  private StreamedContent graphicText;

  public String cropSimple()
  {
    graphicText = DefaultStreamedContent.builder()
      .stream(() -> new ByteArrayInputStream(croppedImageSimple.getBytes()))
      .build();
    return null;
  }

  public String cropCoordinates()
  {
    graphicText = DefaultStreamedContent.builder()
      .stream(() -> new ByteArrayInputStream(croppedImageCoordinates.getBytes()))
      .build();
    return null;
  }

  public String cropAspectRatio()
  {
    graphicText = DefaultStreamedContent.builder()
      .stream(() -> new ByteArrayInputStream(croppedImageAspectRatio.getBytes()))
      .build();
    return null;
  }

  public String cropMinMaxSize()
  {
    graphicText = DefaultStreamedContent.builder()
      .stream(() -> new ByteArrayInputStream(croppedImageMinMaxSize.getBytes()))
      .build();
    return null;
  }

  public StreamedContent getGraphicText()
  {
    return graphicText;
  }

  public CroppedImage getCroppedImageSimple()
  {
    return croppedImageSimple;
  }

  public void setCroppedImageSimple(CroppedImage croppedImageSimple)
  {
    this.croppedImageSimple = croppedImageSimple;
  }

  public CroppedImage getCroppedImageCoordinates()
  {
    return croppedImageCoordinates;
  }

  public void setCroppedImageCoordinates(CroppedImage croppedImageCoordinates)
  {
    this.croppedImageCoordinates = croppedImageCoordinates;
  }

  public CroppedImage getCroppedImageAspectRatio()
  {
    return croppedImageAspectRatio;
  }

  public void setCroppedImageAspectRatio(CroppedImage croppedImageAspectRatio)
  {
    this.croppedImageAspectRatio = croppedImageAspectRatio;
  }

  public CroppedImage getCroppedImageMinMaxSize()
  {
    return croppedImageMinMaxSize;
  }

  public void setCroppedImageMinMaxSize(CroppedImage croppedImageMinMaxSize)
  {
    this.croppedImageMinMaxSize = croppedImageMinMaxSize;
  }
}