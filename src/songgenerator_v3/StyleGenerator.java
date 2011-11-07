package songgenerator_v3;

import java.util.*;


/**
 * Will be used for choosing an instrument,
 * note length, and velocity based on style.
 * 
 * @author ryanjohnson
 * @version 1.3
 */
public class StyleGenerator {

    
    String style;
    int instrument;
    
    public StyleGenerator()
    {
        
    }
    
    public void getInstrument()
    {
        String type;
        Scanner scanner = new Scanner(System.in);
        boolean is_valid = false;
        int inst = 0;
        while(!is_valid)
        {
            System.out.print("Instrument for the pattern to be played on: ");
            type = scanner.nextLine();
            type.toLowerCase();
            
            if(type.equals("piano"))
            {
                inst = 0;
                is_valid = true;
            }
            
            if(type.equals("electric piano"))
            {
                inst = 5;
                is_valid = true;
            }
            
            if(type.equals("bells"))
            {
                inst = 10;
                is_valid = true;
            }
            
            if(type.equals("dulcimer"))
            {
                inst = 15;
                is_valid = true;
            }
            
            // And so on...
         
            setInstrument(inst);
    }
    
}
    
    public void setInstrument(int inst)
    {
        this.instrument = inst;
    }

    public void getStyle()
    {
        // Take in a style and tweak the instrument selected accordingly
    }
}