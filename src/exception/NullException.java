package exception;

@SuppressWarnings("serial")
public class NullException extends Exception {
    public NullException() {
    }
    
    public NullException(String msg) {
        super(msg);
    }
}
