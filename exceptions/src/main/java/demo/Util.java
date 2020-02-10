package demo;

public class Util {

    public static void someMethodWithException() throws Exception {
        throw new Exception("Some meaningful full message!");
    }

    public static void someMethodWithRuntimeException() {
        try {
            someMethodWithException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void someMethodWithThrowDeclaration() throws Exception {
        someMethodWithException();
    }

}
