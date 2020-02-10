package demo;

import javax.swing.*;

public class DemoCodeExceptions {

    public static void main(String[] args) throws Exception {

        // Part 1: Method with Exception
        // - Show and explain with debugger what happen if an exception is not handled (callstack, error message, ...)
        // - main() throws Exception -> delete it.

        Util.someMethodWithException();

        // Part 2: Handle an Exception
        // Show how to handle a exception
        // Explain why you should never throw the base Class Exception (only in the global Exceptionhandler)
        try {
            Util.someMethodWithException();
        } catch (Exception e) { // Try to Catch as specialised as possible (Catch Exception only in the Global Exception Handler)
            System.out.println(e.getMessage());

            // Do NEVER catch an exception without handle it (Log the exception)
            // Handle mean:
            // -> Show a Message to user
            // -> Do logging
        }

        // Part 3: Handle an Exception
        // Show how to handle a exception
        // Explain what throws declaration in method signature does
        try {
            Util.someMethodWithThrowDeclaration();
        } catch (Exception e) { // Try to Catch as specialised as possible (Catch Exception only in the Global Exception Handler)
            System.out.println(e.getMessage());

            // Do NEVER catch an exception without handle it (Log the exception)
            // Handle mean:
            // -> Show a Message to user
            // -> Do logging
        }

        // Part 4: Best-practice: Use only RuntimeException
        // Catch Exceptions and rethrow it as RuntimeExceptions so you can handle it once in a global ExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // -> Show a Message to user
                // -> Do logging
                JOptionPane.showMessageDialog(null, "Something goes wrong!");
            }
        });

        Util.someMethodWithRuntimeException();
    }
}
