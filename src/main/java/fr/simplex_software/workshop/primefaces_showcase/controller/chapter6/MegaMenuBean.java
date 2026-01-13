package fr.simplex_software.workshop.primefaces_showcase.controller.chapter6;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * MegaMenuBean
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@Named
@ViewScoped
public class MegaMenuBean implements Serializable {

	public String getItems() {
		return "Bought items: ...";
	}
}
