package car;

public class License {
    private static Category category;
    private static String number;

    public static String getNumber() {
        return number;
    }

    public static void setNumber(String number) {
        License.number = number;
    }

    public static Category getCategory() {
        return category;
    }

    public static void setCategory(Category category) {
        License.category = category;
    }
}
