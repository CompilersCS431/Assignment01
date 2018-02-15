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
    public States()
    {
        token = new StringBuilder() ;
        prevToken = new String() ;
    }

    public void buildToken(char input)
    {
        String output = new String();
        prevToken = token.toString() ;
        token.append(input) ;

        if(input == ' ' || input == '\n')
        {
            printToken(prevToken) ;
        }
        if(input == '{')
        {
            printToken(prevToken) ;
            printToken("{") ;
        }
        if(input == '(')
        {
            printToken(prevToken) ;
            printToken("(");
        }
        if(input == ')')
        {
            printToken(prevToken);
            printToken(")");
        }
        if(input == '}')
        {
            printToken(prevToken);
            printToken("}");
        }
        if(input == ';')
        {
            printToken(prevToken);
            printToken(";");
        }
        if(input == ',')
        {
            printToken(prevToken);
            printToken(",");
        }
        if(input == '[')
        {
            printToken(prevToken);
            printToken("[");
        }
        if(input == ']')
        {
            printToken(prevToken);
            printToken("]");
        }
        if((input == '.') && !(prevToken.equals("System.out") || prevToken.equals("System"))) //check if the "." is part of print statement
        {
            if((prevToken.length() > 0) && Character.isDigit(prevToken.charAt(0))){ //check if it is an <INTEGER_LITERAL>
                printToken("number");
            }
            else //If not an <INTEGER_LITERAL>, print prevToken & "."
            {
                printToken(prevToken);
                printToken(".");
            }
        }
        if(input == '/'){ //check if the "/" is part of a comment
            if(prevToken.equals("/"))
            {
                printToken("//");
            }
            else if(prevToken.equals("*")){
                printToken("/*");
            }
            else if((prevToken.length() > 0) && prevToken.charAt(prevToken.length()-1) == '*' )
            {
                if(prevToken.charAt(0) == '/' && prevToken.charAt(1) == '*'){
                    printToken("/*");
                }
            }
        }
    }

    public void printToken(String token)
    {
        if(token.equals("class"))
        {
            System.out.print("<TClass>") ;
        }
        if(token.equals("public"))
        {
            System.out.print("<TPublic>") ;
        }
        if(token.equals("static"))
        {
            System.out.print("<TStatic>") ;
        }
        if(token.equals("void"))
        {
            System.out.print("<TVoid>") ;
        }
        if(token.equals("main"))
        {
            System.out.print("<TMain>") ;
        }
        if(token.equals("String"))
        {
            System.out.print("<TString>") ;
        }
        if(token.equals("extends"))
        {
            System.out.print("<TExtends>") ;
        }
        if(token.equals("return"))
        {
            System.out.print("<TReturn>") ;
        }
        if(token.equals("int"))
        {
            System.out.print("<TInt>") ;
        }
        if(token.equals("boolean"))
        {
            System.out.print("<TBool>") ;
        }
        if(token.equals("if"))
        {
            System.out.print("<TIf>") ;
        }
        if(token.equals("else"))
        {
            System.out.print("<TElse>") ;
        }
        if(token.equals("while"))
        {
            System.out.print("<TWhile>") ;
        }
        if(token.equals("System.out.println"))
        {
            System.out.print("<TPrint>") ;
        }
        if(token.equals("length"))
        {
            System.out.print("<TLength>") ;
        }
        if(token.equals("true"))
        {
            System.out.print("<TTrue>") ;
        }
        if(token.equals("false"))
        {
            System.out.print("<TFalse>") ;
        }
        if(token.equals("this"))
        {
            System.out.print("<TThis>") ;
        }
        if(token.equals("new"))
        {
            System.out.print("<TNew>") ;
        }
        if(token.equals("{"))
        {
            System.out.print("<TLcurly>") ;
        }
        if(token.equals("}"))
        {
            System.out.print("<TRcurly>") ;
        }
        if(token.equals("("))
        {
            System.out.print("<TLparen>") ;
        }
        if(token.equals(")"))
        {
            System.out.print("<TRparen>");
        }
        if(token.equals("["))
        {
            System.out.print("<TLbracket>");
        }
        if(token.equals("]"))
        {
            System.out.print("<TRbracket>");
        }
        if(token.equals(","))
        {
            System.out.print("<TComma>");
        }
        if(token.equals(";"))
        {
            System.out.print("<TSemicolon>");
        }
        if(token.equals("&&"))
        {
            System.out.print("<TAnd>");
        }
        if(token.equals("<"))
        {
            System.out.print("<TLt>");
        }
        if(token.equals(">"))
        {
            System.out.print("<TGt>");
        }
        if(token.equals("+"))
        {
            System.out.print("<TPlus>");
        }
        if(token.equals("-"))
        {
            System.out.print("<TMinus>");
        }
        if(token.equals("*"))
        {
            System.out.print("<TTimes>");
        }
        if(token.equals("!"))
        {
          System.out.print("<TExc>");
        }
        if(token.equals("."))
        {
            System.out.print("<TPeriod>");
        }
        if(token.equals("number"))
        {
            System.out.print("<TNumber>");
        }
        if(token.equals("//") || token.equals("/*"))
        {
            System.out.print("<TComments>");
        }
        this.token = new StringBuilder() ;
        this.prevToken = "" ;
    }
}
