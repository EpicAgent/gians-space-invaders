import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextUnderlinePrinter {

    public static void main(String[] args) {

        String ouputText = "Man wird nicht dadurch besser, dass man andere schlechter macht.";
        String underlinedWord = "besser";
        System.out.println(underline(ouputText, underlinedWord));
    }

    /**
     * Underlines all occurrences of word to underline
     * @param haystack Text containing words to underline
     * @param needle The part of the string to underline
     * @return The underlined text
     */
    private static String underline(String haystack, String needle) {
        List<Integer> indexes = findIndexes(haystack, needle);
        char[] underlineChars = new char[haystack.length()];
        for (int i = 0; i < haystack.length(); i++) {
            if (indexes.contains(i)) {
                for (int j = 0; j < needle.length(); j++) {
                    underlineChars[i + j] = '-';
                }
                i += needle.length();
            } else {
                underlineChars[i] = ' ';
            }
        }

        String underlineString = new String(underlineChars);
        return haystack + "\n" + underlineString;
    }

    private static List<Integer> findIndexes(String haystack, String needle) {
        List<Integer> indexes = new ArrayList<>();
        int index = 0;
        while(index != -1){
            index = haystack.indexOf(needle, index);
            if (index != -1) {
                indexes.add(index);
                index++;
            }
        }
        return indexes;
    }
}
