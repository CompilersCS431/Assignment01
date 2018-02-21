package Assign01;


/**
 * Write a description of class States here.
 *
 * @author (Nathan Moder)
 * @version (a version number or a date)
 */
public class States
{
    public static StringBuilder token ;
    public static String prevToken ;
    public static boolean isComment;
    public static boolean isMax;
    public States()
    {
        token = new StringBuilder() ;
        prevToken = new String() ;
        isComment = false;
        isMax = false;
    }

    public void buildToken(char input)
    {
        String output = new String();
        prevToken = token.toString() ;
        token.append(input) ;
        if(!isComment){
           if(input == ' ' || input == '\n' || input == '\t')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken) ;
                }
                
            }
           if(input == '!')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken) ; 
                }
                printToken("!") ;
            }
           if(input == '<')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken) ; 
                }
                printToken("<") ;
            }
            if(input == '>')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken) ; 
                }
                printToken(">") ;
            }
            if(input == '&')
            {
                if(prevToken.equals("&")){
                    printToken("&&") ;
                }
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else if(prevToken.equals("")){
                    
                }
                else {
                    printToken(prevToken) ; 
                }
            }
            if(input == '(')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken) ;
                }
                printToken("(");
            }
            if(input == ')')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken(")");
            }
            if(input == '}')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken("}");
            }
            if(input == '{')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken("{");
            }
            if(input == ';')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken(";");
            }
            if(input == ',')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken(",");
            }
            if(input == '[')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken("[");
            }
            if(input == ']')
            {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken("]");
            }
            if(input == '-') {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken("-");
            }
            if(input == '+') {
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
                printToken("+");
            }
            if((input == '.') && !(prevToken.equals("System.out") || prevToken.equals("System"))) //check if the "." is part of print statement
            {
                if((prevToken.length() > 0) && Character.isDigit(prevToken.charAt(0))){ //check if it is an <INTEGER_LITERAL>
                    printToken("[0-9]");
                }
                else //If not an <INTEGER_LITERAL>, print prevToken & "."
                {
                    printToken(prevToken);
                    printToken(".");
                }
            }
            if(input == '/'){ //check if the "/" is part of a comment
                isComment = true;
                if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                    printToken("[0-9]");
                }
                else {
                    printToken(prevToken);
                }
            }
            if(input == '*') {
                if(prevToken.equals("/")) {
                    printToken("/*");
                    isComment = true;
                }
                else {
                    if(!(prevToken.equals("")) && Character.isDigit(prevToken.charAt(0))) {
                        printToken("[0-9]");
                    }
                    else {
                        printToken(prevToken);
                    }
                    printToken("*");
                }
            }
        }
        if(isComment){
            if(input == '/') {
                if(prevToken.equals("/")){
                    printToken("//");
                }
                else {
                    isComment = false;
                }
            }
            if(isMax) {
                if(prevToken.contains("//")) {
                    this.token = new StringBuilder() ;
                    this.prevToken = "" ;
                    isComment = false;
                }
            }
            if(input == '/'){
                if(prevToken.contains("/*")){
                    printToken("*/");
                }
            }
        }
    }

    public void printToken(String token)
    {
        switch(token) {
                         
            case "class": 
                System.out.print("<TClass>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
                
            case "public":
                System.out.print("<TPublic>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "static":
                System.out.print("<TStatic>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "void":
                System.out.print("<TVoid>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "main":
                System.out.print("<TMain>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "String":
                System.out.print("<TString>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "extends":
                System.out.print("<TExtends>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "return":
                System.out.print("<TReturn>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "int":
                System.out.print("<TInt>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "boolean":
                System.out.print("<TBool>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "if": 
                System.out.print("<TIf>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "else":
                System.out.print("<TElse>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "while":
                System.out.print("<TWhile>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "System.out.println":
                System.out.print("<TPrint>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "length":
                System.out.print("<TLength>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "true":
                System.out.print("<TTrue>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "false":
                System.out.print("<TFalse>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "this":
                System.out.print("<TThis>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "new":
                System.out.print("<TNew>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "{":
                System.out.print("<TLcurly>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "}":
                System.out.print("<TRcurly>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "(":
                System.out.print("<TLparen>") ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ")":
                System.out.print("<TRparen>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "[":
                System.out.print("<TLbracket>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "]":
                System.out.print("<TRbracket>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ",":
                System.out.print("<TComma>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ";":
                System.out.print("<TSemicolon>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "&&":
                System.out.print("<TAnd>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "<":
                System.out.print("<TLt>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ">":
                System.out.print("<TGt>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "+":
                System.out.print("<TPlus>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "-":
                System.out.print("<TMinus>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "*":
                System.out.print("<TTimes>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "=":
                System.out.print("<TEqual>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "!":
                System.out.print("<TExc>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ".":
                System.out.print("<TPeriod>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "[0-9]":
                System.out.print("<TNumber>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "//":
                System.out.print("<TComments>");
                break;
            case "/*":
                System.out.print("<TComments>");
                break;
            case "*/":
                isComment = false;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            default:
                if(!isComment) {
                    if(!(token.equals(""))){
                        if(Character.isLetter(token.charAt(0)) 
                            && !(token.contains("&") 
                                || token.contains("*") 
                                || token.contains("/")
                                || token.contains("\\")
                                || token.contains(".")
                                || token.contains("{")
                                || token.contains("(")
                                || token.contains(")")
                                || token.contains("[")
                                || token.contains("]")
                                || token.contains("}")
                                || token.contains("^")
                                || token.contains(">")
                                || token.contains("<")
                                || token.contains("-")
                                || token.contains("+")
                                || token.contains(";")
                                || token.contains("?")
                                )){
                            System.out.print("<TId>");     
                            this.prevToken = "" ;
                        }
                    }                      
                    this.token = new StringBuilder() ;
                    
                    
                    
                }
                break;
        } 
    }
    
    public void setMax(boolean max) {
        isMax = max;
}
}


