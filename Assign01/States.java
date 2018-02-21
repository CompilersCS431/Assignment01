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
        prevToken = prevToken.trim() ;
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
        boolean isID = true ;
        
        if(token.equals("class"))
        {
            System.out.print("<TClass>") ;
            isID = false ;
        }
        if(token.equals("public"))
        {
            System.out.print("<TPublic>") ;
            isID = false ;
        }
        if(token.equals("static"))
        {
            System.out.print("<TStatic>") ;
            isID = false ;
        }
        if(token.equals("void"))
        {
            System.out.print("<TVoid>") ;
            isID = false ;
        }
        if(token.equals("main"))
        {
            System.out.print("<TMain>") ;
            isID = false ;
        }
        if(token.equals("String"))
        {
            System.out.print("<TString>") ;
            isID = false ;
        }
        if(token.equals("extends"))
        {
            System.out.print("<TExtends>") ;
            isID = false ;
        }
        if(token.equals("return"))
        {
            System.out.print("<TReturn>") ;
            isID = false ;
        }
        if(token.equals("int"))
        {
            System.out.print("<TInt>") ;
            isID = false ;
        }
        if(token.equals("boolean"))
        {
            System.out.print("<TBool>") ;
            isID = false ;
        }
        if(token.equals("if"))
        {
            System.out.print("<TIf>") ;
            isID = false ;
        }
        if(token.equals("else"))
        {
            System.out.print("<TElse>") ;
            isID = false ;
        }
        if(token.equals("while"))
        {
            System.out.print("<TWhile>") ;
            isID = false ;
        }
        if(token.equals("System.out.println"))
        {
            System.out.print("<TPrint>") ;
            isID = false ;
        }
        if(token.equals("length"))
        {
            System.out.print("<TLength>") ;
            isID = false ;
        }
        if(token.equals("true"))
        {
            System.out.print("<TTrue>") ;
            isID = false ;
        }
        if(token.equals("false"))
        {
            System.out.print("<TFalse>") ;
            isID = false ;
        }
        if(token.equals("this"))
        {
            System.out.print("<TThis>") ;
            isID = false ;
        }
        if(token.equals("new"))
        {
            System.out.print("<TNew>") ;
            isID = false ;
        }
        if(token.equals("{"))
        {
            System.out.print("<TLcurly>") ;
            isID = false ;
        }
        if(token.equals("}"))
        {
            System.out.print("<TRcurly>") ;
            isID = false ;
        }
        if(token.equals("("))
        {
            System.out.print("<TLparen>") ;
            isID = false ;
        }
        if(token.equals(")"))
        {
            System.out.print("<TRparen>");
            isID = false ;
        }
        if(token.equals("["))
        {
            System.out.print("<TLbracket>");
            isID = false ;
        }
        if(token.equals("]"))
        {
            System.out.print("<TRbracket>");
            isID = false ;
        }
        if(token.equals(","))
        {
            System.out.print("<TComma>");
            isID = false ;
        }
        if(token.equals(";"))
        {
            System.out.print("<TSemicolon>");
            isID = false ;
        }
        if(token.equals("&&"))
        {
            System.out.print("<TAnd>");
            isID = false ;
        }
        if(token.equals("<"))
        {
            System.out.print("<TLt>");
            isID = false ;
        }
        if(token.equals(">"))
        {
            System.out.print("<TGt>");
            isID = false ;
        }
        if(token.equals("+"))
        {
            System.out.print("<TPlus>");
            isID = false ;
        }
        if(token.equals("-"))
        {
            System.out.print("<TMinus>");
            isID = false ;
        }
        if(token.equals("*"))
        {
            System.out.print("<TTimes>");
            isID = false ;
        }
        if(token.equals("!"))
        {
          System.out.print("<TExc>");
          isID = false ;
        }
        if(token.equals("."))
        {
            System.out.print("<TPeriod>");
            isID = false ;
        }
        if(token.equals("number"))
        {
            System.out.print("<TNumber>");
            isID = false ;
        }
        if(token.equals("//") || token.equals("/*"))
        {
            System.out.print("<TComments>");
            isID = false ;
        }
        if(isID && !prevToken.equals(""))
        {
            System.out.print("<TId>") ;
        }
        this.token = new StringBuilder() ;
        this.prevToken = "" ;
    }
}
