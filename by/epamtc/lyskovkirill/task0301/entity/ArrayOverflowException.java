package by.epamtc.lyskovkirill.task0301.entity;

public class ArrayOverflowException extends Exception {

    public ArrayOverflowException() {
        super();
    }

    public ArrayOverflowException(String message) {
        super(message);
    }

    public ArrayOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayOverflowException(Throwable cause) {
        super(cause);
    }
}