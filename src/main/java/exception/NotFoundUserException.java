package exception;

public class NotFoundUserException extends Exception{
    private String err;

    public NotFoundUserException() {
    }

    public NotFoundUserException(String message) {
        super(message);
    }

    public NotFoundUserException(String message, String err) {
        super(message);
        this.err = err;
    }

    public String getErr() {
        return err;
    }
}
