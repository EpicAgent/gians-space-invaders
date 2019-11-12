public class NullPointerExample {

    public static void main(String[] args) {

        int numberToCheck = 0;
        Result result = isNumberBiggerThanZero(numberToCheck);
        if (result.isRight()){
            System.out.println("The number was bigger than zero");
        }
    }

    public static Result isNumberBiggerThanZero(int number){
         Result result = null;
         if (number > 0) {
             result = new Result(true);
         } else {  // In der Aufgabenstellung wird hier der Wert 0 nicht berücksichtigt!
             result = new Result(false);
         }
         return result;
    }
}
