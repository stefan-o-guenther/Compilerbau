package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface EvaluatorInteger extends Evaluator {
    Integer evaluateAndGetInteger() throws Exception;
}
