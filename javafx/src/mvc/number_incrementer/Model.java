package mvc.number_incrementer;

import javafx.beans.property.SimpleIntegerProperty;

public class Model {
    private SimpleIntegerProperty currentValue = new SimpleIntegerProperty(0);
    private int incrementStep = 1;

    public int getCurrentValue() {
        return currentValue.get();
    }
    public SimpleIntegerProperty currentValueProperty() {
        return currentValue;
    }
    public void setCurrentValue(int currentValue) {
        this.currentValue.set(currentValue);
    }

    public int getIncrementStep() {
        return incrementStep;
    }

    public void setIncrementStep(int incrementStep) {
        this.incrementStep = incrementStep;
    }


}
