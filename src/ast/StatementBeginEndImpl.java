package ast;

import java.util.ArrayList;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementBeginEndImpl extends StatementAbstract implements StatementBeginEnd {
    
    private ArrayList<Statement> listStatement = new ArrayList<Statement>();
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            try {
                for (Statement statement : listStatement) {
                    statement.evaluateOnlyAndDebug(debug);
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            throw e;
        }        
    }

    @Override
    public void addStatement(Statement statement) {
        try {
            listStatement.add(statement);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void analyse() throws Exception {
        try {
            for (Statement statement : listStatement) {
                statement.analyse();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
