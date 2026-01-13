package fr.simplex_software.workshop.primefaces_showcase.controller.chapter11;

import org.primefaces.context.RequestContext;

import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * RequestContextBean
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@Named
@ViewScoped
public class RequestContextBean implements Serializable {

	private boolean firstOutput = true;

	private int counter = 0;

	public void incrementWithUpdate(ActionEvent ae) {
		counter++;

		RequestContext requestContext =
                RequestContext.getCurrentInstance();

		if (firstOutput) {
			requestContext.update("firstOutput");
		} else {
			requestContext.update("secondOutput");
		}
	}

	public void incrementWithScroll(ActionEvent ae) {
		counter++;

		RequestContext requestContext =
                RequestContext.getCurrentInstance();
		requestContext.scrollTo("counter");
	}

	public boolean isFirstOutput() {
		return firstOutput;
	}

	public void setFirstOutput(boolean firstOutput) {
		this.firstOutput = firstOutput;
	}

	public int getCounter() {
		return counter;
	}
}
