package frontend;

import java.util.ArrayList;
import java.util.LinkedList;

import exception.LexicalErrorException;
import exception.NullException;
import exception.SyntaxErrorException;

/**
 * PL/0 Lexer
 * Der Lexer wandelt einen String mit dem Progammcode in eine verkettete Liste von Token um.
 * 
 * @author Stefan Günther
 * @version 1.0
 */
public class Lexer {

    private static String text = "";
    private static Boolean isNumber = false;
    private static String code = "";
    
    private static ArrayList<Token> listToken = new ArrayList<Token>();
    private static ArrayList<Brace> _listBrace = new ArrayList<Brace>();
    
    
    /**
     * scannt den Code nach Token.
     * 
     * @throws Exception
     */
    private static void scan() throws Exception {
        
        text = "";
        isNumber = false;
        listToken.clear();
        
        code += "       ";
        Boolean nocomment = true;
        Boolean nostring = true;
        Integer index = 0;
        Integer length = code.length();
        while (index < (length-1)) {
            Character char1 = code.charAt(index);
            Character char2 = code.charAt(index+1);
            
            if (nocomment && nostring) {
                switch (char1) {
                    case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': {
                        if (nocomment) {
                            if (text == "") {
                                isNumber = true;
                            }
                            text += char1;
                        }
                        break;
                    }
                    case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H': case 'I': case 'J': case 'K': case 'L': case 'M':
                    case 'N': case 'O': case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z':
                    case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i': case 'j': case 'k': case 'l': case 'm':
                    case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z': {
                        if (isNumber) {
                            throw new LexicalErrorException();
                        } else {
                            text += char1;
                        }
                        break;
                    }
                    case ' ': case '\n': case '\t': case '\f': case '\r': {
                        saveText();
                        break;
                    }
                    case '=': {
                        saveText();
                        tokenize(TokenFactory.createTokenEqual());
                        break;
                    }
                    case '.': {
                        saveText();
                        tokenize(TokenFactory.createTokenDot());
                        break;
                    }
                    case ',': {
                        saveText();
                        tokenize(TokenFactory.createTokenComma());
                        break;
                    }
                    case ';': {
                        saveText();
                        tokenize(TokenFactory.createTokenSemicolon());
                        break;
                    }
                    case ':': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenAssignment());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenColon());
                                break;
                            }
                        }
                        break;
                    }
                    case '?': {
                        saveText();
                        tokenize(TokenFactory.createTokenQuestionMark());
                        break;
                    }
                    case '!': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenNotEqual());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenExclamationMark());
                                break;
                            }
                        }
                        break;
                    }
                    case '#': {
                        saveText();
                        tokenize(TokenFactory.createTokenNotEqual());
                        break;
                    }
                    case '<': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenLessEqual());
                                index += 1;
                                break;
                            }
                            case '>': {
                                tokenize(TokenFactory.createTokenNotEqual());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenLessThan());
                                break;
                            }
                        }
                        break;
                    }
                    case '>': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenGreaterEqual());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenGreaterThan());
                                break;
                            }
                        }
                        break;
                    }
                    case '+': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenAssignmentAddition());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenAddition());
                                break;
                            }
                        }
                        break;
                    }
                    case '-': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenAssignmentSubtraction());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenSubtraction());
                                break;
                            }
                        }
                        break;
                    }
                    case '*': {
                        saveText();
                        switch (char2) {
                            case ')': {
                                throw new LexicalErrorException();
                            }
                            case '=': {
                                tokenize(TokenFactory.createTokenAssignmentMultiplication());
                                index += 1;
                                break;
                            }
                            case '*': {
                                tokenize(TokenFactory.createTokenExponentiation());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenMultiplication());
                                break;
                            }
                        }
                        break;
                    }
                    case '/': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenAssignmentDivision());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenDivision());
                                break;
                            }
                        }
                        break;
                    }
                    case '%': {
                        saveText();
                        switch (char2) {
                            case '=': {
                                tokenize(TokenFactory.createTokenAssignmentModulo());
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenModulo());
                                break;
                            }
                        }
                        break;
                    }
                    case '(': {
                        saveText();
                        switch (char2) {
                            case '*': {
                                nocomment = false;
                                index += 1;
                                break;
                            }
                            default: {
                                tokenize(TokenFactory.createTokenBraceOpen());
                                break;
                            }
                        }
                        break;
                    }
                    case ')': {
                        saveText();
                        tokenize(TokenFactory.createTokenBraceClose());
                        break;
                    }
                    case '_': {
                        switch (text) {
                            case "": {
                                text += char1;
                                break;
                            }
                            default: {
                                throw new LexicalErrorException();
                            }
                        }
                        break;
                    }
//                    case '[': {
//                        saveText();
//                        tokenize(TokenFactory.createTokenBracketOpen());
//                        break;
//                    }
//                    case ']': {
//                        saveText();
//                        tokenize(TokenFactory.createTokenBracketClose());
//                        break;
//                    }
                    case '&': {
                        saveText();
                        tokenize(TokenFactory.createTokenAnd());
                        break;
                    }
                    case '|': {
                        saveText();
                        tokenize(TokenFactory.createTokenOr());
                        break;
                    }
                    case '\'': {
                        saveText();
                        nostring = false;
                        break;
                    }
                    case '^': {
                        saveText();
                        tokenize(TokenFactory.createTokenExponentiation());
                        break;
                    }
                    default: {
                        throw new LexicalErrorException();
                    }
                }
            } else if (nocomment == false) {
                if ((char1 == '*') && (char2 == ')')) {
                    nocomment = true;
                    index += 1;
                }
            } else if (nostring == false) {
                if (char1 == '\'') {
                    tokenize(TokenFactory.createTokenString(text));
                    text = "";
                    nostring = true;
                } else {
                    text += char1;
                }
            }
            index += 1;
        }
        if ((nocomment == false) || nostring == false) {
            throw new LexicalErrorException();
        }
    }
    
    
    /**
     * speichert den Token in die Token-Liste.
     * 
     * @param token
     * @throws Exception
     */
    private static void tokenize(Token token) throws Exception {
        if (token != null) {
            listToken.add(token);
        }
    }
    
    
    /**
     * speichert den Text als Zahl oder als Identifier.
     * 
     * @throws Exception
     */
    private static void saveText() throws Exception {
        if (isNumber) {
            saveNumber();
        } else {
            saveIdentifier();
        }
        text = "";
        isNumber = false;
    }
    
    
    /**
     * wandelt den Text in eine Zahl um und speichert diese als Token.
     * 
     * @throws Exception
     */
    private static void saveNumber() throws Exception {
        if (text.equals("") == false) {
            try {
                Integer number = Integer.decode(text);
                tokenize(TokenFactory.createTokenNumber(number));
            }
            catch ( NumberFormatException e ) {
                throw new LexicalErrorException();
            }
        }
    }
    
    
    /**
     * speichert den Text als Identifier.
     * 
     * @throws Exception
     */
    private static void saveIdentifier() throws Exception {
        if (text.equals("") == false) {
            switch (text) {
                case "AND": {
                    tokenize(TokenFactory.createTokenAnd());
                    break;
                }
                case "BEGIN": {
                    tokenize(TokenFactory.createTokenBegin());
                    break;
                }
                case "CALL": {
                    tokenize(TokenFactory.createTokenCall());
                    break;
                }
                case "CONST": {
                    tokenize(TokenFactory.createTokenConstant());
                    break;
                }
                case "DEBUG": {
                    tokenize(TokenFactory.createTokenDebug());
                    break;
                }
                case "DEC": {
                    tokenize(TokenFactory.createTokenDecrement());
                    break;
                }
                case "DO": {
                    tokenize(TokenFactory.createTokenDo());
                    break;
                }
                case "ELSE": {
                    tokenize(TokenFactory.createTokenElse());
                    break;
                }
                case "END": {
                    tokenize(TokenFactory.createTokenEnd());
                    break;
                }
                case "EVEN": {
                    tokenize(TokenFactory.createTokenEven());
                    break;
                }
                case "FOR": {
                    tokenize(TokenFactory.createTokenFor());
                    break;
                }
                case "IF": {
                    tokenize(TokenFactory.createTokenIf());
                    break;
                }
                case "INC": {
                    tokenize(TokenFactory.createTokenIncrement());
                    break;
                }
                case "NOT": {
                    tokenize(TokenFactory.createTokenNot());
                    break;
                }
                case "ODD": {
                    tokenize(TokenFactory.createTokenOdd());
                    break;
                }
                case "OR": {
                    tokenize(TokenFactory.createTokenOr());
                    break;
                }
                case "PROCEDURE": {
                    tokenize(TokenFactory.createTokenProcedure());
                    break;
                }
                case "PROGRAM": {
                    tokenize(TokenFactory.createTokenProgram());
                    break;
                }
                case "REPEAT": {
                    tokenize(TokenFactory.createTokenRepeat());
                    break;
                }
                case "TERNARY": {
                    tokenize(TokenFactory.createTokenTernary());
                    break;
                }
                case "THEN": {
                    tokenize(TokenFactory.createTokenThen());
                    break;
                }
                case "TO": {
                    tokenize(TokenFactory.createTokenTo());
                    break;
                }
                case "UNTIL": {
                    tokenize(TokenFactory.createTokenUntil());
                    break;
                }
                case "VAR": {
                    tokenize(TokenFactory.createTokenVariable());
                    break;
                }
                case "WHILE": {
                    tokenize(TokenFactory.createTokenWhile());
                    break;
                }
                case "WRITELN": {
                    tokenize(TokenFactory.createTokenWriteLn());
                    break;
                }
                default: {
                    tokenize(TokenFactory.createTokenIdentifier(text));
                    break;
                }
            }
        }
    }
    
    
    /**
     * Durchsucht die Liste von Token nach Klammerpaaren. 
     * 
     * @throws Exception
     */
    private static void searchBraces() throws Exception {
        try {
            LinkedList<Integer> listPosition = new LinkedList<Integer>();            
            for (int i = 0; i < listToken.size(); i++) {
                Token token = listToken.get(i);
                switch (token.getIdentifier()) {
                    case TokenBraceOpen: {
                        listPosition.addLast(i);
                        break;
                    }
                    case TokenBraceClose: {
                        Integer j = listPosition.removeLast();
                        Brace brace = new BraceImpl(j,i);
                        _listBrace.add(brace);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            if (listPosition.size() > 0) {
                throw new SyntaxErrorException();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /**
     * Wandelt, wenn nötig, Token von runden Klammern (Braces) in Token von eckigen Klammern (Brackets) um.
     * Brackets sind die Klammern bei Conditions.
     * 
     * @throws Exception
     */
    private static void convertBracesToBrackets() throws Exception {
        try {
            for (Brace brace : _listBrace) {
                Integer i = brace.getBegin() + 1;
                Boolean isBracket = false;
                while ((i < brace.getEnd()) && (isBracket == false)) {
                    Token token = listToken.get(i);
                    switch (token.getIdentifier()) {
                        case TokenEqual: case TokenNotEqual: case TokenLessThan: case TokenLessEqual: case TokenGreaterThan: 
                        case TokenGreaterEqual: case TokenOr: case TokenAnd: case TokenEven: case TokenOdd: case TokenNot: {
                            isBracket = true;
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    i += 1;
                }
                if (isBracket) {
                    Token tokenOpen = listToken.get(brace.getBegin());
                    Token tokenClose = listToken.get(brace.getEnd());
                    tokenOpen.setIdentifier(TokenEnum.TokenBracketOpen);
                    tokenClose.setIdentifier(TokenEnum.TokenBracketClose);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /**
     * wandelt einen Text mit dem Quellcode in eine Liste von Token um.
     * 
     * @param sourcecode
     * @return
     * @throws Exception
     */
    public static ArrayList<Token> lex(String sourcecode) throws Exception {
        try {
            if (sourcecode == null) {
                throw new NullException();
            }
            code = sourcecode;
            listToken = new ArrayList<Token>();
            scan();
            tokenize(TokenFactory.createTokenEmpty());
            searchBraces();
            convertBracesToBrackets();
            return listToken;
        } catch (Exception e) {
            throw e;
        }
    }
}
