package car;

public class Car {
    private boolean inMotion;
    private Driver driver;
    private License requiredLicense;

    public void drive() {
        if (driver == null) {
            throw new IllegalStateException("This car needs to have a driver in order to drive. Please set a driver first.");
        }
        if (!driver.hasValidLicense()) {
            throw new IllegalStateException("The driver of this car has not a valid driver license category to drive this car.");
        }
        System.out.println("Car driving");
        inMotion = true;
    }

    public void stop() {
        inMotion = false;
    }

    public boolean isInMotion() {
        return inMotion;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public License getRequiredLicense() {
        return requiredLicense;
    }

    public void setRequiredLicense(License requiredLicense) {
        this.requiredLicense = requiredLicense;
    }
}
