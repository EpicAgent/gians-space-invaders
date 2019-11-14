package konstruktoren;

public class SomeClass {

    private int variableInt;
    private long variableLong;
    private float variableFloat;
    private double variableDouble;

    public SomeClass(int variableInt, long variableLong, float variableFloat, double variableDouble) {
        this(variableInt, variableLong, variableFloat);
        this.variableDouble = variableDouble;
    }

    public SomeClass(int variableInt, long variableLong, float variableFloat) {
        this(variableInt, variableLong);
        this.variableFloat = variableFloat;
    }

    public SomeClass(int variableInt, long variableLong) {
        this(variableInt);
        this.variableLong = variableLong;
    }

    public SomeClass(int variableInt) {
        this.variableInt = variableInt;
    }
}
