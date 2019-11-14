import somepackage.OtherClass; // erste Zeile

public class SomeClass {
    public static void main(String[] args) {
        OtherClass.say(); // mitten im Code
        OtherClass.text = "Hallo";
        OtherClass.say();
    }
}
