package ast;

import java.util.LinkedList;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class VariableImpl extends DatatypeAbstract implements Variable 
{

    private LinkedList<Integer> listValue = new LinkedList<Integer>();
    
    public VariableImpl(String name) throws Exception 
    {
        super(name, "var", 0);
    }
        
    @Override
    public void setValue(Integer value) throws Exception 
    {
        try 
        {
            if (value == null) 
            {
                throw new NullException(this.getClass().toString());
            }
            this.setDatatypeValue(value);
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }

    @Override
    public void pushValue() throws Exception 
    {
        try 
        {
            listValue.add(this.getValue());
            this.setDatatypeValue(0);
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }

    @Override
    public void popValue() throws Exception 
    {
        try 
        {
            int max = listValue.size() - 1;
            if (max >= 0) {
                this.setDatatypeValue(listValue.remove(max));
            } else {
                this.setDatatypeValue(0);
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}
