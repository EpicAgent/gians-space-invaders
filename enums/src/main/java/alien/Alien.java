package alien;

public class Alien {
    private Gender gender = Gender.OTHER;

    public void printGender() {
        switch (gender) {
            case MALE:
                System.out.println("My gender is male.");
            case FEMALE:
                System.out.println("My gender is female.");
            default:
                System.out.println("My gender is other.");
        }
    }
}
