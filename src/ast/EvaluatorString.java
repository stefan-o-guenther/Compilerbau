package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface EvaluatorString extends Evaluator {
    String evaluateAndGetString() throws Exception;
}
