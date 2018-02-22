package Assign01;


/**
 * Write a description of class Analyzer here.
 * 
 * CS 431 - Compilers
 * 
 * @author (Nathan Moder) 
 * @version (2/14/18)
 */
import java.io.* ;
import java.util.Scanner;
import javax.swing.* ;
public class Analyzer
{
    public static void readFile(String filename) throws IOException
    {
        String output = "";
        
        BufferedWriter write = new BufferedWriter(new FileWriter(new File("output1")));
        
        BufferedReader br = new BufferedReader(new FileReader(filename)) ;
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
        
       // System.out.print(output);
       write.write(output);
	   write.write("\r\n");
       write.close();
    }
    
}



