package demo_controls;

public class Person {

    private String firstName;
    private String lastName;
    private String location;

    public Person() {

    }

    public Person(String lastName, String firstName, String location) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.location = location;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
