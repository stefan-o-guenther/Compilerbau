package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface ConditionBracket extends Condition {
    void setDisjunction(Disjunction disjunction) throws Exception;
    Disjunction getDisjunction();
}
