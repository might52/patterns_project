package entity;

import Interfaces.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Calendar;
import java.util.Date;

public class Day implements Test {

    private Date date;

    public Day() {
        this.date = Calendar.getInstance().getTime();
    }

    public Day(final Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    @Override
    public void Show() {
        System.out.println("Был вызван Show() у Date");
    }

    @Override
    public String toString() {
        return "Day{" +
                "date=" + date +
                '}';
    }

    @Override
    public void finalize() throws Throwable{
        System.out.println("Вазван деструкток финализатор класса " + this.getClass().getName());
    }
}
