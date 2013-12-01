package exception;

@SuppressWarnings("serial")
public class MathematicalErrorException extends Exception {
    public MathematicalErrorException() {
    }
    
    public MathematicalErrorException(String msg) {
        super(msg);
    }
}
