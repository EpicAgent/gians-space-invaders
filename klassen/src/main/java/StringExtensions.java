public class StringExtensions {

    public static void main(String[] args) {
        String text = "Hallo Welt!";
        System.out.println("reversed: " + reverse(text));

        String zahl = "12345";
        System.out.println(sumOfTheDigits(zahl)); // Quersumme
    }

    static String reverse(String text){
        String reversedText = "";
        for (int i = 0; i < text.length() ; i++) {
            reversedText = text.charAt(i) + reversedText;
        }
        return reversedText;
    }

    private static int sumOfTheDigits(String value) {
        int result = 0;
        for ( int i = 0; i < value.length(); i++ )
            result += (value.charAt( i ) - '0');

        return result;
    }
}
