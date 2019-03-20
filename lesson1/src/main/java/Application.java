import entity.Day;
import entity.DayTime;
import sounds.Speaker;
import sounds.Writer;
import sounds.Auditory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

/**
 * Object for start application.
 */
public class Application {
    /**
     * Main function.
     * @param args - system args.
     */
    public static void main(final String[] args) {
/*
        Day day = new Day(Calendar.getInstance().getTime());
        System.out.println(day);
        DayTime dayTime = new DayTime(Calendar.getInstance().getTime(), new Timer());
        dayTime.getTimer().cancel();
        System.out.println(dayTime);
        day.Show();
        dayTime.Show2();
        dayTime.Show();
        try {
            day.finalize();
            dayTime.finalize();
        }
        catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
*/
        List<Writer> writers = new ArrayList<Writer>();

        writers.add(new Writer("first"));
        writers.add(new Writer("Second"));
        writers.add(new Writer("Third"));
        writers.add(new Writer("Fourth"));
        writers.add(new Writer("Fifth"));
        writers.add(new Writer("Sixth"));
        writers.add(new Writer("Seventh"));

        Auditory auditory = new Auditory(1);
        writers.forEach(el -> el.setAuditory(auditory));
        auditory.setWriters(writers);

        Speaker speaker = new Speaker();
        speaker.setAuditory(auditory);

        speaker.makeSound();
    }
}
