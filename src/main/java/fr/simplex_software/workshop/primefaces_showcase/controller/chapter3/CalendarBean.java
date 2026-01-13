package fr.simplex_software.workshop.primefaces_showcase.controller.chapter3;

import org.apache.commons.lang3.time.DateUtils;
import fr.simplex_software.workshop.primefaces_showcase.utils.MessageUtil;
import org.primefaces.event.SelectEvent;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * User: mertcaliskan
 * Date: 6/28/12
 */
@Named
@ViewScoped
public class CalendarBean implements Serializable {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getYesterday() {
        return DateUtils.addDays(new Date(), -1);
    }

    public Date getTomorrow() {
        return DateUtils.addDays(new Date(), 1);
    }

    public void onDateSelect(SelectEvent event) {
        Date date = (Date)event.getObject();
        MessageUtil.addInfoMessage("selected.date", date);
    }
}
