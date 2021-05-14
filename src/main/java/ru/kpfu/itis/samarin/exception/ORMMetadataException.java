package ru.kpfu.itis.samarin.exception;

public class ORMMetadataException extends RuntimeException{
    public ORMMetadataException() {
        super();
    }

    public ORMMetadataException(String message) {
        super(message);
    }

    public ORMMetadataException(Throwable cause) {
        super(cause);
    }

    public ORMMetadataException(String message, Throwable cause) {
        super(message, cause);
    }
}
