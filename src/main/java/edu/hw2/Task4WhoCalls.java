package edu.hw2;

public class Task4WhoCalls {
    private Task4WhoCalls() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        StackTraceElement caller = stackTrace[1];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {
    }



}

