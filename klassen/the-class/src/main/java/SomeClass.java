public class SomeClass {
    static final String CONSTANT = "PI";
    static int variable;

    static void someMethod(){
        variable = someMethodWithReturn();
        someMethodWithParam(variable, CONSTANT);
    }
    static void someMethodWithParam(int i, String s){
        System.out.println(CONSTANT);
    }



    static int someMethodWithReturn(){
        return variable;
    }
}
