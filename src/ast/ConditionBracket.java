package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface ConditionBracket extends Condition {
    void setDisjunction(Disjunction disjunction) throws Exception;
    Disjunction getDisjunction();
}
