package car;

public class Car {
    private static boolean inMotion;
    private static String driverName;



    public static void drive() {
        if (driverName == null || driverName.isEmpty()) {
            throw new IllegalStateException("This car needs to have a driver in order to drive. Please set a driver first.");
        }
        System.out.println("Car driving");
        inMotion = true;
    }

    public static void stop() {
        inMotion = false;
    }

    public static boolean isInMotion() {
        return inMotion;
    }

    public static String getDriverName() {
        return driverName;
    }

    public static void setDriverName(String driverName) {
        Car.driverName = driverName;
    }
}
