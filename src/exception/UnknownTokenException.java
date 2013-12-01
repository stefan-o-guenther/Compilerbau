package exception;

@SuppressWarnings("serial")
public class UnknownTokenException extends Exception {
    public UnknownTokenException() {
    }
    
    public UnknownTokenException(String msg) {
        super(msg);
    }
    
}
