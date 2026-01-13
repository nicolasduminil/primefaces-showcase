package fr.simplex_software.workshop.primefaces_showcaseconverter;

import fr.simplex_software.workshop.primefaces_showcase.controller.chapter2.UserSettingsBean;
import fr.simplex_software.workshop.primefaces_showcase.model.chapter2.Theme;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * ThemeConverter
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@Named
@SessionScoped
public class ThemeConverter implements Serializable, Converter {
    
    @Inject
    private UserSettingsBean userSettingsBean;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Theme> themes = userSettingsBean.getAvailableThemes();
        for (Theme theme : themes) {
            if (theme.getName().equals(value)) {
                return theme;
            }
        }
        
        return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((Theme) value).getName();
	}
}
