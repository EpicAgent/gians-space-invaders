public class BbcMath {

    public static void main(String[] args) {

        int i = 10; // Wenn du nichts angibst, ist 10 ein Integer
        long l = 10l; // Durch das kleine "l", wird die 10 zu einem Long
        float f = 10f; // Durch das kleine "f", wird die 10 zum Float
        double d = 10d; // Durch das kleine "d", wird die 10 zu einem Double

        // Aufgaben zu Methodenüberladung:
        // Schreibe die Methode "add" viermal. Verwende immer den Methodennamen "add" und Methodenüberladung.
        System.out.println("Add mit Integer: " + add(i,i));
        System.out.println("Add mit Long: " + add(l, l));
        System.out.println("Add mit Float: " + add(f, f));
        System.out.println("Add mit Double: " + add(d, d));

        // Extra
        System.out.println("Ist 7 gerade? " + isEven(7));
        System.out.println("Ist 8 gerade? " + isEven(8));
    }

    static int add(int number1, int number2) {
        return number1 + number2;
    }

    static long add(long number1, long number2) {
        return number1 + number2;
    }

    static float add(float number1, float number2) {
        return number1 + number2;
    }

    static double add(double number1, double number2) {
        return number1 + number2;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
