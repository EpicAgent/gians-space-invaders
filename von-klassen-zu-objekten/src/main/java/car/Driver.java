package car;

import java.util.Date;

public class Driver {

    private static String name;
    private static Date birthdate;
    private License license;
    private Car car;

    public boolean hasValidLicense() {
        return license.getCategory() == car.getRequiredLicense().getCategory();
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Driver.name = name;
    }

    public static Date getBirthdate() {
        return birthdate;
    }

    public static void setBirthdate(Date birthdate) {
        Driver.birthdate = birthdate;
    }

}
