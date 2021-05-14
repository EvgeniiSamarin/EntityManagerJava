package ru.kpfu.itis.samarin.exception;

public class ORMManagerException extends RuntimeException {
    public ORMManagerException() {
        super();
    }

    public ORMManagerException(String message) {
        super(message);
    }

    public ORMManagerException(Throwable cause) {
        super(cause);
    }

    public ORMManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
