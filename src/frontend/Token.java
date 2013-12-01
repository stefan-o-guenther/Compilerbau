package frontend;

public interface Token {
    TokenEnum getIdentifier();
    void setIdentifier(TokenEnum identifier) throws Exception;
    Object getValue();
    void setValue(Object value) throws Exception;
}
