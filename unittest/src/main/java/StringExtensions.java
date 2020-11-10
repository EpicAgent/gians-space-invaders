public class StringExtensions {

    public static void main(String[] args) {
        String text = "Hallo Welt!";
        System.out.println("reversed: " + reverse(text));

        String zahl = "12345";
        System.out.println(quersum(zahl)); // Quersumme
    }

    public static String reverse(String text){
        String reversedText = "";
        for (int i = 0; i < text.length() ; i++) {
            reversedText = text.charAt(i) + reversedText;
        }
        return reversedText;
    }

    public static int quersum(String value) {
        int result = 0;
        char c = '0';
        for ( int i = 0; i < value.length(); i++ ) {
            c = value.charAt(i);
            if (!Character.isDigit(c)) throw new RuntimeException("Input contains non digit characters: " + value);
            result += Integer.parseInt(Character.toString(c));
        }
        return result;
    }
}
