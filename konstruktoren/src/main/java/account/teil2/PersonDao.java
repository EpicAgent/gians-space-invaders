package account.teil2;

public class PersonDao {

    private static String[][] peopleNames = new String[][] {
            {"Hans", "Meier"},
            {"Ueli", "Müller"},
    };

    public static Person[] getAll() {
        Person[] people = new Person[peopleNames.length];
        for (int i = 0; i < peopleNames.length; i++) {
            Person person = new Person(peopleNames[i][0], peopleNames[i][1]);
            people[i] = person;
        }
        return people;
    }
}
