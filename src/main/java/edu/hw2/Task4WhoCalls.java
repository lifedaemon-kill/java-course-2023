package edu.hw2;

public class Task4WhoCalls {
    private Task4WhoCalls() {
    }

    public record CallingInfo(String className, String methodName) {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
//        if (stackTrace.length < 3) {
//            return new CallingInfo("unknown", "unknown");
//        }
        StackTraceElement caller = stackTrace[1];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        return new CallingInfo(className, methodName);
    }

}

