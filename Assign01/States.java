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
        this.token = new StringBuilder() ;
        this.prevToken = "" ;
    }
}
