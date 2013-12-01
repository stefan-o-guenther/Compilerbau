package ast;

import exception.NullException;

/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementIfThenElseImpl extends StatementAbstract implements StatementIfThenElse {

    private Statement statementThen = StatementFactory.createStatementEmpty();
    private Statement statementElse = StatementFactory.createStatementEmpty();
    private Disjunction disjunction = DisjunctionFactory.createDisjunctionEmpty();
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            if (disjunction.evaluateAndGetBoolean()) {
                statementThen.evaluateOnlyAndDebug(debug);
            } else {
                statementElse.evaluateOnlyAndDebug(debug);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void analyse() throws Exception {
        try {
            disjunction.analyse();
            statementThen.analyse();
            statementElse.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setStatementThen(Statement statement) {
        try {
            statementThen = statement;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setStatementElse(Statement statement) {
        try {
            statementElse = statement;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void setDisjunction(Disjunction disjunction) throws Exception {
        try {
            if (disjunction == null) {
                throw new NullException(this.getClass().toString());
            }
            this.disjunction = disjunction;
        } catch (Exception e) {
            throw e;
        }
    }
}
