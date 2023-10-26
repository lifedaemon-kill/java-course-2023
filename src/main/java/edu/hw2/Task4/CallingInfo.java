package edu.hw2.Task4;


public record CallingInfo(String className, String methodName) {

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        StackTraceElement caller = stackTrace[1];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        return new CallingInfo(className, methodName);
    }
}
