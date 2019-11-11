package ch.bbcag.syntax;

public class Wecker {

    public static void main(String[] args) {
        System.out.println(alarmClock(1, true));

        for (int i = 1; i <= 7; ++i) {
            System.out.println(alarmClock(i, false));
        }
    }

    public static String alarmClock(int day, boolean vacation) {
        if (vacation) {
            return null;
        }

        if (day >= 6) {
            return "10:00";
        }

        return "07:00";
    }

}
