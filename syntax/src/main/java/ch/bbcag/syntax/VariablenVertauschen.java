package ch.bbcag.syntax;

public class VariablenVertauschen {

    public static void main(String[] args) {
        double a = Math.random();
        double b = Math.random();

        if (a < b) {
            double tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println("A: " + a + "; B: " + b);
    }

}
