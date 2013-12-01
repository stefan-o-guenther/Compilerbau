package exception;

@SuppressWarnings("serial")
public class OutOfTokenListException extends Exception {
    public OutOfTokenListException() {
    }
    
    public OutOfTokenListException(String msg) {
        super(msg);
    }
}
