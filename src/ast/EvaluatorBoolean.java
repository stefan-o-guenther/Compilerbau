package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface EvaluatorBoolean extends Evaluator {
    Boolean evaluateAndGetBoolean() throws Exception;
}
