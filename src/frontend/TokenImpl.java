package frontend;

import exception.NullException;

public class TokenImpl implements Token {
    
    private TokenEnum identifier = TokenEnum.TokenEmpty;
    private Object value = null;
    
    public TokenImpl() {
        this.identifier = TokenEnum.TokenEmpty;
        this.value = null;
    }
    
    public TokenImpl(TokenEnum identifier) throws Exception {
        try {
            this.setIdentifier(identifier);
            this.value = null;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public TokenImpl(TokenEnum identifier, Object value) throws Exception {
        try {
            this.setIdentifier(identifier);
            this.setValue(value);
        } catch (Exception e) {
            throw e;
        }        
    }

    @Override
    public TokenEnum getIdentifier() {
        return identifier;
    }
    
    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setIdentifier(TokenEnum identifier) throws Exception {
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
    public void setValue(Object value) throws Exception {
        try {
            if (value == null) {
                throw new NullException(this.getClass().toString());
            }
            this.value = value;
        } catch (Exception e) {
            throw e;
        }        
    }
}
