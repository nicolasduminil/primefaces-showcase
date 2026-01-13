package fr.simplex_software.workshop.primefaces_showcase.controller.chapter5;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Phrase;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter5.CountryList;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 8/28/12
 */
@Named
@ViewScoped
public class DataExportBean implements Serializable {

    private String[] selectedCountries;
    
    public List<String> getCountries() {
        return CountryList.countries;
    }

    public void preProcessPDF(Object document) {
        Document pdf = (Document) document;
        HeaderFooter footer = new HeaderFooter(new Phrase("This is page: "), true);
        pdf.setFooter(footer);
    }

    public String[] getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(String[] selectedCountries) {
        this.selectedCountries = selectedCountries;
    }
}