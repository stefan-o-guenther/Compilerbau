package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public abstract class StatementConditionLoopAbstract extends StatementAbstract implements StatementConditionLoop {
    
    private Statement statement = StatementFactory.createStatementEmpty();
    private Disjunction disjunction = DisjunctionFactory.createDisjunctionEmpty();
    
    protected Boolean getDisjunctionResult() throws Exception {
        try {
            return disjunction.evaluateAndGetBoolean();
        } catch (Exception e) {
            throw e;
        }        
    }
    
    protected void evaluateStatement(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            statement.evaluateOnlyAndDebug(debug);
        } catch (Exception e) {
            throw e;
        }
    }    
    
    @Override
    public final void setStatement(Statement statement) throws Exception {
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
    public final void setDisjunction(Disjunction disjunction) throws Exception {
        try {
            if (disjunction == null) {
                throw new NullException(this.getClass().toString());
            }
            this.disjunction = disjunction;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            disjunction.analyse();
            statement.analyse();
        } catch (Exception e) {
            throw e;
        }
    } 
}
