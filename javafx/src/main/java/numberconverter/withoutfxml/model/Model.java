package numberconverter.withoutfxml.model;



import javafx.beans.property.*;
import numberconverter.withoutfxml.enums.Mode;


public class Model {

    private IntegerProperty intValue;
    private StringProperty mainDisplayValue;
    private StringProperty decDisplayValue;
    private StringProperty hexDisplayValue;
    private StringProperty binDisplayValue;
    private StringProperty octDisplayValue;
    private ObjectProperty<Mode> currentMode;

    public Model() {
        currentMode = new SimpleObjectProperty<Mode>(Mode.DEC);
        mainDisplayValue = new SimpleStringProperty("0");
        decDisplayValue = new SimpleStringProperty("0");
        hexDisplayValue = new SimpleStringProperty("0");
        binDisplayValue = new SimpleStringProperty("0");
        octDisplayValue = new SimpleStringProperty("0");
        intValue = new SimpleIntegerProperty(0);
    }

    public int getIntValue() {
        return intValue.get();
    }

    public IntegerProperty intValueProperty() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue.set(intValue);
    }

    public String getDecDisplayValue() {
        return decDisplayValue.get();
    }

    public void setDecDisplayValue(String decDisplayValue) {
        this.decDisplayValue.set(decDisplayValue);
    }

    public String getHexDisplayValue() {
        return hexDisplayValue.get();
    }

    public void setHexDisplayValue(String hexDisplayValue) {
        this.hexDisplayValue.set(hexDisplayValue);
    }

    public String getBinDisplayValue() {
        return binDisplayValue.get();
    }

    public void setBinDisplayValue(String binDisplayValue) {
        this.binDisplayValue.set(binDisplayValue);
    }

    public String getOctDisplayValue() {
        return octDisplayValue.get();
    }

    public void setOctDisplayValue(String octDisplayValue) {
        this.octDisplayValue.set(octDisplayValue);
    }


    public StringProperty decDisplayValueProperty() {
        return decDisplayValue;
    }

    public StringProperty hexDisplayValueProperty() {
        return hexDisplayValue;
    }

    public StringProperty binDisplayValueProperty() {
        return binDisplayValue;
    }

    public StringProperty octDisplayValueProperty() {
        return octDisplayValue;
    }


    public String getMainDisplayValue() {
        return mainDisplayValue.get();
    }

    public StringProperty mainDisplayValueProperty() {
        return mainDisplayValue;
    }

    public void setMainDisplayValue(String mainDisplayValue) {
        this.mainDisplayValue.set(mainDisplayValue);
    }

    public Mode getCurrentMode() {
        return currentMode.get();
    }

    public ObjectProperty<Mode> currentModeProperty() {
        return currentMode;
    }

    public void setCurrentMode(Mode currentMode) {
        this.currentMode.set(currentMode);
    }







}
