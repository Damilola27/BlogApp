package exceptions;

public class CommentAlreadyExistException extends Throwable {
    public CommentAlreadyExistException() {
        super();
    }

    public CommentAlreadyExistException(String message) {
        super(message);
    }

    public CommentAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommentAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
