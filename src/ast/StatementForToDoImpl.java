package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementForToDoImpl extends StatementAbstract implements StatementForToDo {
    
    private Statement statement = StatementFactory.createStatementEmpty();
    private Expression expressionFrom = ExpressionFactory.createExpressionEmpty();
    private Expression expressionTo = ExpressionFactory.createExpressionEmpty();
    private Procedure parent = null;
    private String identifier = "";
    private Variable variable = null;
    
    @Override
    public void analyse() throws Exception {
        try {
            variable = TypeFinder.findVariable(parent, identifier);
            expressionFrom.analyse();
            expressionTo.analyse();
            statement.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setIdentifier(String identifier) throws Exception {
        try {
            if (identifier == null) {
                throw new NullException(this.getClass().toString());
            }
            this.identifier = identifier;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setParent(Procedure parent) throws Exception {
        try {
            if (parent == null) {
                throw new NullException(this.getClass().toString());
            }
            this.parent = parent;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setStatement(Statement statement) throws Exception {
        try {
            if (statement == null) {
                throw new NullException(this.getClass().toString());
            }
            this.statement = statement;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer numberFrom = expressionFrom.evaluateAndGetInteger();
            Integer numberTo = expressionTo.evaluateAndGetInteger();
            
            if (numberFrom <= numberTo) {
                for (int index = numberFrom; index <= numberTo; index++) {
                    variable.setValue(index);
                    statement.evaluateOnlyAndDebug(debug);
                }
            } else {
                for (int index = numberFrom; index >= numberTo; index--) {
                    variable.setValue(index);
                    statement.evaluateOnlyAndDebug(debug);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setExpressionFrom(Expression expression) throws NullException {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            expressionFrom = expression;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setExpressionTo(Expression expression) throws NullException {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            expressionTo = expression;
        } catch (Exception e) {
            throw e;
        }
    }
}
