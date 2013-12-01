package exception;

@SuppressWarnings("serial")
public class SemanticErrorException extends Exception {
    public SemanticErrorException() {
    }
    
    public SemanticErrorException(String msg) {
        super(msg);
    }
}
