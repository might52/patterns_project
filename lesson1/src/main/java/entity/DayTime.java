package entity;

import Interfaces.TestBig;

import java.util.Date;
import java.util.Timer;

public class DayTime extends Day implements TestBig{
    private Timer timer;

    public DayTime(Timer timer) {
        this.timer = timer;
    }

    public DayTime(Date date, Timer timer) {
        super(date);
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "DayTime{" +
                "day=" + this.getDate() +
                " timer=" + timer +
                '}';
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("Вазван деструкток финализатор класса " + this.getClass().getName());
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println(" + вызван он из DayTime");
    }

    @Override
    public void Show2() {
        System.out.println("Был вызван Show2() у DayTime");
    }
}
