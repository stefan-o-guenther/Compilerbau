package exception;

@SuppressWarnings("serial")
public class WrongIndexException extends Exception {
    public WrongIndexException() {
    }
    
    public WrongIndexException(String msg) {
        super(msg);
    }
}
