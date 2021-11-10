package exceptions;

public class PostNotFoundException extends Throwable {
    public PostNotFoundException() {
        super();
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PostNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PostNotFoundException(String post_does_not_exist) {

    }
}
