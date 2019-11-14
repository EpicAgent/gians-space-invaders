package konstruktoren;

public class SomeApp {
    public static void main(String[] args) {

        int variableInt = 1;
        long variableLong = 1l;
        float variableFloat = 1.0f;
        double variableDouble = 1.0d;

        SomeClass s1 = new SomeClass(variableInt);
        SomeClass s2 = new SomeClass(variableInt, variableLong);
        SomeClass s3 = new SomeClass(variableInt, variableLong, variableFloat);
        SomeClass s4 = new SomeClass(variableInt, variableLong, variableFloat, variableDouble);
    }
}
