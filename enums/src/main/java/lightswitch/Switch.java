package lightswitch;

public class Switch {
    private State state = State.OFF;

    public void push() {
        if (state == State.OFF) {
            state = State.ON;
        } else {
            state = State.OFF;
        }
    }
}
