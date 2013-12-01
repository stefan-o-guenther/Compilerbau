package frontend;

import exception.NullException;

public class BraceImpl implements Brace {
    
    private Integer begin = null;
    private Integer end = null;
        
    public BraceImpl(Integer begin, Integer end) throws Exception {
        try {
            this.setBegin(begin);
            this.setEnd(end);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Integer getBegin() {
        return begin;
    }
    
    @Override
    public void setBegin(Integer begin) throws Exception {
        try {
            if (begin == null) {
                throw new NullException(this.getClass().toString());
            }
            this.begin = begin;
        } catch (Exception e) {
            throw e;
        }        
    }
    
    @Override
    public Integer getEnd() {
        return end;
    }
    
    @Override
    public void setEnd(Integer end) throws Exception {
        try {
            if (end == null) {
                throw new NullException(this.getClass().toString());
            }
            this.end = end;
        } catch (Exception e) {
            throw e;
        }        
    }    
}
