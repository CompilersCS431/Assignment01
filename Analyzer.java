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
        String output = ""; 
        
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
        
        System.out.print(output);
    }
    
    
    
    public static void main(String[] args) throws IOException {
        Analyzer.readFile();
    }
}



