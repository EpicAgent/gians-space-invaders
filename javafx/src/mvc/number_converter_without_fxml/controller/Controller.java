package mvc.number_converter_without_fxml.controller;

import mvc.number_converter_without_fxml.enums.Mode;
import mvc.number_converter_without_fxml.model.Model;

public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void handleModeChange(Mode newMode) {
        model.setCurrentMode(newMode);
        updateMainDisplayValue();
    }

    /**
     * Handles text input of our main display
     * @param newValue The new text input value
     * @return Returns true if we could handle new text input, otherwise false
     */
    public boolean handleTextInput(String newValue) {
        boolean success = true;
        if (newValue.equals("")) {
            model.setIntValue(0);
        } else {
            try {
                switch (model.getCurrentMode()) {
                    case DEC:
                        model.setIntValue(Integer.parseInt(newValue));
                        break;
                    case BIN:
                        model.setIntValue(Integer.parseInt(newValue, 2));
                        break;
                    case HEX:
                        model.setIntValue(Integer.parseInt(newValue, 16));
                        break;
                    case OCT:
                        model.setIntValue(Integer.parseInt(newValue, 8));
                }
            } catch (NumberFormatException e) {
                success = false;
            }
        }

        return success;
    }

    private void updateLabelDisplayValues() {
        model.setDecDisplayValue(Integer.toString(model.getIntValue()));
        model.setHexDisplayValue(Integer.toHexString(model.getIntValue()));
        model.setBinDisplayValue(Integer.toBinaryString(model.getIntValue()));
        model.setOctDisplayValue(Integer.toOctalString(model.getIntValue()));
    }

    public void updateDisplayValues() {
        updateMainDisplayValue();
        updateLabelDisplayValues();
    }

    private void updateMainDisplayValue() {
        switch (model.getCurrentMode()) {
            case DEC:
                model.setMainDisplayValue(Integer.toString(model.getIntValue()));
                break;
            case BIN:
                model.setMainDisplayValue(Integer.toBinaryString(model.getIntValue()));
                break;
            case HEX:
                model.setMainDisplayValue(Integer.toHexString(model.getIntValue()));
                break;
            case OCT:
                model.setMainDisplayValue(Integer.toOctalString(model.getIntValue()));
                break;
        }
    }

}
