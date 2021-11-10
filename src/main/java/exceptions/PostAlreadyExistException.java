package exceptions;

public class PostAlreadyExistException extends Throwable {
    public PostAlreadyExistException() {
        super();
    }

    public PostAlreadyExistException(String message) {
        super(message);
    }

    public PostAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
