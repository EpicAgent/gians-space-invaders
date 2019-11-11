package workingalien;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Alien {
    private DayOfWeek freeDay = DayOfWeek.FRIDAY; // Default value

    public void work() {
        if (freeDay == DateUtil.getCurrentDayOfWeek()) {
            System.out.println("This alien is not working on " + freeDay.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        } else {
            System.out.println("This alien is now working.");
        }
    }

    public DayOfWeek getFreeDay() {
        return freeDay;
    }

    public void setFreeDay(DayOfWeek freeDay) {
        this.freeDay = freeDay;
    }
}
