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
import javax.swing.* ;
public class Analyzer
{
    public static void readFile() throws IOException
    {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        File inFile ;
        
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            inFile = chooser.getSelectedFile();
        }
        else
        {
            inFile = null ;
        }
        
        
        
        BufferedReader br = new BufferedReader(new FileReader(inFile)) ;
        String line ;
        line = br.readLine() ;
        while(line != null)
        {
            //read one character at a time
            States state = new States() ;
            for(int i = 0 ; i < line.length() ; i++)
            {
                char curChar = line.charAt(i) ;
                state.buildToken(curChar) ;
            }
            
            line = br.readLine() ;
        }
    }
}
