package ch.bbcag.syntax;

public class Aufgabe1 {
    public static void main(String[] args) {
        int a = -1;
        double b = 10.0;
        // Dies ist ein Kommentar
        double resultat = a + b;
        String text = "Das Resultat ist: " + resultat;

        if (resultat < 10.0) {
            System.out.println("Gratulation!");
        } else /* Kommentar */  {
            System.out.println(text);
        }


        int i = 3;
        switch (i) {
            case 1:
                System.out.println("Eins");
                break;
            case 2:
                System.out.println("Zwei");
                break;
            case 3:
            case 4:
                System.out.println("Drei oder Vier");
            break;
            default:
                System.out.println("Andere Zahl");
        }

    }
}
