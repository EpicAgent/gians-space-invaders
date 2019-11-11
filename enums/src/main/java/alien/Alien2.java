package alien;

public class Alien2 {
    private Gender gender = Gender.OTHER;

    public void printGender() {
        if (gender == Gender.FEMALE) {
            System.out.println("My gender is female.");
        } else if (gender == Gender.MALE) {
            System.out.println("My gender is male.");
        } else {
            System.out.println("My gender is other.");
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
