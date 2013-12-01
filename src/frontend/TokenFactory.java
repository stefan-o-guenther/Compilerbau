package frontend;


public class TokenFactory {

    //    +
    public static Token createTokenAddition() throws Exception {
        return new TokenImpl(TokenEnum.TokenAddition);
    }
    
    //    &
    public static Token createTokenAnd() throws Exception {
        return new TokenImpl(TokenEnum.TokenAnd);
    }
    
    //    :=
    public static Token createTokenAssignment() throws Exception {
        return new TokenImpl(TokenEnum.TokenAssignment);
    }
    
    //    +=
    public static Token createTokenAssignmentAddition() throws Exception {
        return new TokenImpl(TokenEnum.TokenAssignmentAddition);
    }
    
    //    /=
    public static Token createTokenAssignmentDivision() throws Exception {
        return new TokenImpl(TokenEnum.TokenAssignmentDivision);
    }
    
    //    %=
    public static Token createTokenAssignmentModulo() throws Exception {
        return new TokenImpl(TokenEnum.TokenAssignmentModulo);
    }
    
    //    *=
    public static Token createTokenAssignmentMultiplication() throws Exception {
        return new TokenImpl(TokenEnum.TokenAssignmentMultiplication);
    }
    
    //    -=
    public static Token createTokenAssignmentSubtraction() throws Exception {
        return new TokenImpl(TokenEnum.TokenAssignmentSubtraction);
    }
    
    //    BEGIN
    public static Token createTokenBegin() throws Exception {
        return new TokenImpl(TokenEnum.TokenBegin);
    }
    
    //    )
    public static Token createTokenBraceClose() throws Exception {
        return new TokenImpl(TokenEnum.TokenBraceClose);
    }
    
    //    (
    public static Token createTokenBraceOpen() throws Exception {
        return new TokenImpl(TokenEnum.TokenBraceOpen);
    }
    
    //    ]
    public static Token createTokenBracketClose() throws Exception {
        return new TokenImpl(TokenEnum.TokenBracketClose);
    }
    
    //    [
    public static Token createTokenBracketOpen() throws Exception {
        return new TokenImpl(TokenEnum.TokenBracketOpen);
    }
    
    //    CALL
    public static Token createTokenCall() throws Exception {
        return new TokenImpl(TokenEnum.TokenCall);
    }
    
    //    :
    public static Token createTokenColon() throws Exception {
        return new TokenImpl(TokenEnum.TokenColon);
    }
    
    //    ,
    public static Token createTokenComma() throws Exception {
        return new TokenImpl(TokenEnum.TokenComma);
    }
    
    //    CONST
    public static Token createTokenConstant() throws Exception {
        return new TokenImpl(TokenEnum.TokenConstant);
    }
    
    //    DEBUG
    public static Token createTokenDebug() throws Exception {
        return new TokenImpl(TokenEnum.TokenDebug);
    }
    
    //    DEC
    public static Token createTokenDecrement() throws Exception {
        return new TokenImpl(TokenEnum.TokenDecrement);
    }
    
    //    /
    public static Token createTokenDivision() throws Exception {
        return new TokenImpl(TokenEnum.TokenDivision);
    }
    
    //    DO
    public static Token createTokenDo() throws Exception {
        return new TokenImpl(TokenEnum.TokenDo);
    }
    
    //    .
    public static Token createTokenDot() throws Exception {
        return new TokenImpl(TokenEnum.TokenDot);
    }
    
    //    ELSE
    public static Token createTokenElse() throws Exception {
        return new TokenImpl(TokenEnum.TokenElse);
    }
    
    //    Empty
    public static Token createTokenEmpty() throws Exception {
        return new TokenImpl(TokenEnum.TokenEmpty);
    }
    
    //    END
    public static Token createTokenEnd() throws Exception {
        return new TokenImpl(TokenEnum.TokenEnd);
    }
    
    //    =
    public static Token createTokenEqual() throws Exception {
        return new TokenImpl(TokenEnum.TokenEqual);
    }
    
    //    EVEN
    public static Token createTokenEven() throws Exception {
        return new TokenImpl(TokenEnum.TokenEven);
    }
    
    //  ^
    public static Token createTokenExclamationMark() throws Exception {
        return new TokenImpl(TokenEnum.TokenExclamationMark);
    }
    
    //    ^
    public static Token createTokenExponentiation() throws Exception {
        return new TokenImpl(TokenEnum.TokenExponentiation);
    }
    
    //    FOR
    public static Token createTokenFor() throws Exception {
        return new TokenImpl(TokenEnum.TokenFor);
    }
    
    //    >=
    public static Token createTokenGreaterEqual() throws Exception {
        return new TokenImpl(TokenEnum.TokenGreaterEqual);
    }
    
    //    >
    public static Token createTokenGreaterThan() throws Exception {
        return new TokenImpl(TokenEnum.TokenGreaterThan);
    }
    
    //    (_A..Za..z){A..Za..z}
    public static Token createTokenIdentifier(String value) throws Exception {
        return new TokenImpl(TokenEnum.TokenIdentifier, value);
    }
    
    //    IF
    public static Token createTokenIf() throws Exception {
        return new TokenImpl(TokenEnum.TokenIf);
    }
    
    //    INC
    public static Token createTokenIncrement() throws Exception {
        return new TokenImpl(TokenEnum.TokenIncrement);
    }
    
    //    <=
    public static Token createTokenLessEqual() throws Exception {
        return new TokenImpl(TokenEnum.TokenLessEqual);
    }
    
    //    <
    public static Token createTokenLessThan() throws Exception {
        return new TokenImpl(TokenEnum.TokenLessThan);
    }
    
    //    %
    public static Token createTokenModulo() throws Exception {
        return new TokenImpl(TokenEnum.TokenModulo);
    }
    
    //    *
    public static Token createTokenMultiplication() throws Exception {
        return new TokenImpl(TokenEnum.TokenMultiplication);
    }
    
    //    TERNARY
    public static Token createTokenNot() throws Exception {
        return new TokenImpl(TokenEnum.TokenNot);
    }
    
    //    #    !=    <>
    public static Token createTokenNotEqual() throws Exception {
        return new TokenImpl(TokenEnum.TokenNotEqual);
    }
    
    //    (0..9){0..9}
    public static Token createTokenNumber(Integer value) throws Exception {
        return new TokenImpl(TokenEnum.TokenNumber, value);
    }
    
    //    ODD
    public static Token createTokenOdd() throws Exception {
        return new TokenImpl(TokenEnum.TokenOdd);
    }
    
    //    |
    public static Token createTokenOr() throws Exception {
        return new TokenImpl(TokenEnum.TokenOr);
    }
    
    //    PROCEDURE
    public static Token createTokenProcedure() throws Exception {
        return new TokenImpl(TokenEnum.TokenProcedure);
    }
    
    //    ?
    public static Token createTokenQuestionMark() throws Exception {
        return new TokenImpl(TokenEnum.TokenQuestionMark);
    }
    
    //    REPEAT
    public static Token createTokenRepeat() throws Exception {
        return new TokenImpl(TokenEnum.TokenRepeat);
    }
    
    //    ;
    public static Token createTokenSemicolon() throws Exception {
        return new TokenImpl(TokenEnum.TokenSemicolon);
    }
    
    //    '--'
    public static Token createTokenString(String value) throws Exception {
        return new TokenImpl(TokenEnum.TokenString, value);
    }
    
    //    -
    public static Token createTokenSubtraction() throws Exception {
        return new TokenImpl(TokenEnum.TokenSubtraction);
    }
    
    //    TERNARY
    public static Token createTokenTernary() throws Exception {
        return new TokenImpl(TokenEnum.TokenTernary);
    }
    
    //    THEN
    public static Token createTokenThen() throws Exception {
        return new TokenImpl(TokenEnum.TokenThen);
    }
    
    //    To
    public static Token createTokenTo() throws Exception {
        return new TokenImpl(TokenEnum.TokenTo);
    }
    
    //    UNTIL
    public static Token createTokenUntil() throws Exception {
        return new TokenImpl(TokenEnum.TokenUntil);
    }
    
    //    VAR
    public static Token createTokenVariable() throws Exception {
        return new TokenImpl(TokenEnum.TokenVariable);
    }
    
    //    WHILE
    public static Token createTokenWhile() throws Exception {
        return new TokenImpl(TokenEnum.TokenWhile);
    }

    //    WRITELN
    public static Token createTokenWriteLn() throws Exception {
        return new TokenImpl(TokenEnum.TokenWriteLn);
    }

    public static Token createTokenProgram() throws Exception {
        return new TokenImpl(TokenEnum.TokenProgram);
    }
}
