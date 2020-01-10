package praesi;

public class Demo3 {

    public static void main(String[] args) {

        try {

            /* some Code */
            throw new Exception("Invalid Arguments");

            /* unreachable Code*/
            //System.out.println("Wird nie ausgeführt");

        } catch (Exception e) {

            /* handle the Exception */
            System.out.println("Error: " + e.getMessage());

        }
    }
}
