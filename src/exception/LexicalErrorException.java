package exception;

@SuppressWarnings("serial")
public class LexicalErrorException extends Exception {
    public LexicalErrorException() {
    }
    
    public LexicalErrorException(String msg) {
        super(msg);
    }
}
