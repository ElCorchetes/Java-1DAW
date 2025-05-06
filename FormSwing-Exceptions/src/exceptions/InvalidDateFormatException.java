package exceptions;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException() {
        super();
    }
    public InvalidDateFormatException(String message) {
        super(message);
    }
}
