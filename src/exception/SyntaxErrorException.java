package exception;

@SuppressWarnings("serial")
public class SyntaxErrorException extends Exception {
    public SyntaxErrorException() {
    }
    
    public SyntaxErrorException(String msg) {
        super(msg);
    }
}
