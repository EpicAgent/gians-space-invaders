package demo;

import javax.swing.*;

public class ExceptionsDemoApp {

    public static void main(String[] args) throws Exception {

        //someMethodWithRuntimeException();

        // Part 1: Method with Exception
        // Show and explain what happen if an exception is not handled (callstack, error message, ...)
        someMethodWithException();

        // Part 2: Handle an Exception
        try {
            someMethodWithException();
        } catch (Exception e) { // Try to Catch as specialised as possible (Catch Exception only in the Global Exception Handler)
            e.printStackTrace();

            // Do NEVER catch an exception without handle it (Log the exception)
            // Handle mean:
            // -> Show a Message to user
            // -> Do logging
        }

        // Part 3: Best-practice: Use only RuntimeException
        // Catch Exceptions and rethrow it as RuntimeExceptions so you can handle it once in a global ExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // -> Show a Message to user
                // -> Do logging
                JOptionPane.showConfirmDialog(null, "Something goes wrong!");
            }
        });

        // Part 3: Best-practice: Use only RuntimeException
        // Catch Exceptions and rethrow it as RuntimeExceptions so you can handle it once in a global ExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // -> Show a Message to user
                // -> Do logging
                JOptionPane.showMessageDialog(null, "Something goes wrong!");
            }
        });

        someMethodWithRuntimeException();
    }

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
}


