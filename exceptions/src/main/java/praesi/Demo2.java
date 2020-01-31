package praesi;

public class Demo2 {

    public static void main(String[] args) {
        try {
            /* some Code which throw an Exception */
        } catch (Exception e) {
            /* handle the Exception */
        }

        try {
            /* some Code which throw an Exception */
        } catch (Exception e) {
            /* handle the Exception */
        } finally {
            /* do cleaning tasks */
        }

        try {
            /* some Code which throw an Exception */
        } finally {
            /* do cleaning tasks */
        }
    }
}
