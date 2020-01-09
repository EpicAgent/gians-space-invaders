package praesi;

public class App {

    public void demo() {

        try {

            /* some Code */
            doSomething();
            /* some Code */

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    private void doSomething() throws Exception {
        throw new Exception("Invalid Arguments");
    }
}
