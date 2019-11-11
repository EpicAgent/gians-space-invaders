package ch.bbcag.ae.ersteschritte;

public class Blackjack {

    public static void main(String[] args) {
        System.out.println("Test erfolgreich: " + blackjackTester());
    }

    public static int blackjack(int a, int b) {
        if (a < 0 || b < 0) {
            return 0;
        }

        boolean aOver21 = a > 21;
        boolean bOver21 = b > 21;

        if (aOver21 && bOver21) {
            return 0;
        }

        if (bOver21) {
            return a;
        }

        if (aOver21) {
            return b;
        }

        if (a < b) {
            return b;
        } else {
            return a;
        }
    }

    private static boolean blackjackTester() {
        boolean success = true;
        if (!(blackjack(19, 21) == 21))
            success = false;
        if (!(blackjack(21, 19) == 21))
            success = false;
        if (!(blackjack(19, 22) == 19))
            success = false;
        if (!(blackjack(22, 19) == 19))
            success = false;
        if (!(blackjack(22, 50) == 0))
            success = false;
        if (!(blackjack(22, 22) == 0))
            success = false;
        if (!(blackjack(33, 1) == 1))
            success = false;
        if (!(blackjack(1, 2) == 2))
            success = false;
        if (!(blackjack(34, 33) == 0))
            success = false;
        if (!(blackjack(17, 19) == 19))
            success = false;
        if (!(blackjack(18, 17) == 18))
            success = false;
        if (!(blackjack(16, 23) == 16))
            success = false;
        if (!(blackjack(3, 4) == 4))
            success = false;
        if (!(blackjack(3, 2) == 3))
            success = false;
        if (!(blackjack(21, 20) == 21))
            success = false;

        return success;
    }


}
