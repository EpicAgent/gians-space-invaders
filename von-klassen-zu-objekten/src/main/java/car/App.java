package car;



public class App {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
            }
        });

        Category cat1 = Category.A;
        Category cat2 = Category.A;

        if (cat1 == cat2) {
            System.out.println("true");
        }




    }
}
