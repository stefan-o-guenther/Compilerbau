package ast;


public interface TernaryOperator extends AssignmentOperand {
    void setDisjunction(Disjunction disjunction) throws Exception;
    void setExpressionThen(Expression expression) throws Exception;
    void setExpressionElse(Expression expression) throws Exception;
}
