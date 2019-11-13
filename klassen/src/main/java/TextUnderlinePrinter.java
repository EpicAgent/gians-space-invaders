public class TextUnderlinePrinter {

    public static void main(String[] args) {

        String ouputText = "Man wird nicht dadurch besser, dass man andere schlecht macht.";
        String underlinedWord = "besser";
        System.out.println(ouputText);
        underline(ouputText, underlinedWord);

    }

    static void underline(String text, String searchWord) {
        for (int i = 0, last = 0; i >= 0; i++) {
            i = text.indexOf(searchWord, i);

            if (i < 0) break;

            outputChar(i, last, ' ');
            outputChar(searchWord.length(), 0, '-');
            last = i + searchWord.length();
        }
    }

    static void outputChar(int i, int last, char c) {
        for (int j = last; j < i; j++)
            System.out.print(c);
    }
}
