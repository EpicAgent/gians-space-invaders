package mvc.number_incrementer;

public class Controller {

    private final Model model;
    public Controller(Model model) {
        this.model = model;
    }

    public void incrementCurrentValue() {
        model.setCurrentValue(model.getCurrentValue() + model.getIncrementStep());
    }

    public void updateIncrementStep(int incrementStep) {
        model.setIncrementStep(incrementStep);
    }

}
