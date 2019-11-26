package numberconverter.withfxml.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import numberconverter.withfxml.enums.Mode;

public class Model {

    public Model() {
        value = new SimpleIntegerProperty(0);
        currentMode = Mode.DEC;
    }

    public Mode getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(Mode currentMode) {
        this.currentMode = currentMode;
    }

    private Mode currentMode;

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    private IntegerProperty value;

}
