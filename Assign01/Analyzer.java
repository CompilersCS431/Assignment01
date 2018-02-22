/**
 * Write a description of class Analyzer here.
 * 
 * CS 431 - Compilers
 * 
 * @author (Nathan Moder) 
 * @version (2/14/18)
 */
import java.io.* ;
import javax.swing.* ;
public class Analyzer
{
    public static void readFile(String fpIn , String fpOut) throws IOException
    {
        File inFile = new File(fpIn) ;
        File outFile = new File(fpOut) ;
        
        String output = "";    
        
        BufferedReader br = new BufferedReader(new FileReader(inFile)) ;
        PrintWriter pw = new PrintWriter(new FileWriter(outFile)) ;
        String line ;
        line = br.readLine() ;
        States state = new States() ;
        boolean max;
        while(line != null)
        {
            //read one character at a time
            max = false;
            state.setMax(max);
            for(int i = 0 ; i < line.length() ; i++)
            {
                char curChar = line.charAt(i) ;
                if(i == (line.length() - 1)){
                    max = true;
                    state.setMax(max);
                }
                output += state.buildToken(curChar) ;
            }
            
            line = br.readLine() ;
        }
        
        System.out.println(output + "\n" ) ;
        pw.print(output) ;
        br.close() ;
        pw.close() ;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        Analyzer.readFile( "./prog1.txt" , "./answer1.txt" ) ;
    }
}



