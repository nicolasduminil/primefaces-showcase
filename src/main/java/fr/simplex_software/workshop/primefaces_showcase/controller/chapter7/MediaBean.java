package fr.simplex_software.workshop.primefaces_showcase.controller.chapter7;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by mertcaliskan
 * on 26/01/15.
 */
@Named
@SessionScoped
public class MediaBean implements Serializable {

    public StreamedContent getMedia() throws IOException {
        InputStream stream = this.getClass().getResourceAsStream("/chapter7/sample_iTunes.mov");
        return new DefaultStreamedContent(stream, "video/quicktime");
    }
}
