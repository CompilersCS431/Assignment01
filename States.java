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
    public static String output; 
    public States()
    {
        token = new StringBuilder() ;
        prevToken = new String() ;
        isComment = false;
        isMax = false;
        output = new String();
    }

    public String buildToken(char input)
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
        
        if(isMax){
            String temp = this.output;
            this.output = "";
            return temp;
        }
        else {
            return "";
        } 
    }

    public String printToken(String token)
    {        
        switch(token) {
                         
            case "class": 
                output += "<TClass>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
                
            case "public":
                output += "<TPublic>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "static":
                output += "<TStatic>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "void":
                output += "<TVoid>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "main":
                output += "<TMain>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "String":
                output += "<TString>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "extends":
                output += "<TExtends>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "return":
                output += "<TReturn>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "int":
                output += "<TInt>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "boolean":
                output += "<TBool>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "if": 
                output += "<TIf>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "else":
                output += "<TElse>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "while":
                output += "<TWhile>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "System.out.println":
                output += "<TPrint>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "length":
                output += "<TLength>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "true":
                output += "<TTrue>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "false":
                output += "<TFalse>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "this":
                output += "<TThis>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "new":
                output += "<TNew>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "{":
                output += "<TLcurly>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "}":
                output += "<TRcurly>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "(":
                output += "<TLparen>" ;
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ")":
                output += "<TRparen>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "[":
                output += "<TLbracket>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "]":
                output += "<TRbracket>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ",":
                System.out.print("<TComma>");
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ";":
                output += "<TSemicolon>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "&&":
                output += "<TAnd>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "<":
                output += "<TLt>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ">":
                output += "<TGt>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "+":
                output += "<TPlus>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "-":
                output += "<TMinus>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "*":
                output += "<TTimes>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "=":
                output += "<TEqual>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "!":
                output += "<TExc>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case ".":
                output += "<TPeriod>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "[0-9]":
                output += "<TNumber>";
                this.token = new StringBuilder() ;
                this.prevToken = "" ;
                break;
            case "//":
                output += "<TComments>";
                break;
            case "/*":
                output += "<TComments>";
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
                            output += "<TId>";     
                            this.prevToken = "" ;
                        }
                    }                      
                    this.token = new StringBuilder() ;
                    
                    
                    
                }
                break;
        } 
        
        return "";
        
    }
    
    public void setMax(boolean max) {
        isMax = max;
    }
}


