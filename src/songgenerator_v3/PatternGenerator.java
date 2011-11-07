package songgenerator_v3;

/**
 * Class for getting the scale components 
 * of the pattern.
 * 
 * @author Ryan Johnson
 * @version 1.3
 */

import java.util.*;

public class PatternGenerator {
    
    int num_notes;
    int offSet;
    String base_note;
    String scale;
    
    public PatternGenerator()
    {
        // Constructor for instantiating this class
    }
       

    // Method for getting the number of notes
    public void getNumNotes()
    {
        int total;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of notes in the pattern: ");
        
        // **Note!** 
        // this crashes if what is entered is not an int
       
        total = scanner.nextInt();
        setNumNotes(total);
    }
    
    // Sets the class variable for num_notes
    public void setNumNotes(int total)
    {
        this.num_notes = total;
    }
    
    // Get the root note
    public void getBaseNote()
    {
        // Initializes the base note
        String note = "c";
        Scanner scanner = new Scanner(System.in);
        
        // Loops until we get a valid input
        boolean valid_key = false;
        while(!valid_key)
        {
            // Allows input of all notes, flat or sharp
            System.out.print("Enter the root note(A-G + b or #): ");
            note = scanner.nextLine();
            
            // Regex that checks for valid notes
            if (note.matches("[a-gA-g][b#]") || note.matches("[a-gA-G]") )
            {
                int offSet = 0;
                
                // Offsets the root note around C as the start
                if(note.matches("[cC]") || note.matches("[bB][#]"))
                {
                    offSet = 0;
                }
                
                if(note.matches("[cC][#]") || note.matches("[dD][b]"))
                {
                    offSet = 1;
                }
                
                if(note.matches("[dD]"))
                {
                    offSet = 2;
                }
                
                if(note.matches("[dD][#]") || note.matches("[eE][b]"))
                {
                    offSet = 3;
                }
                
                if(note.matches("[eE]") || note.matches("[fF][b]"))
                {
                    offSet = 4;
                }
                
                if(note.matches("[eE][#]") || note.matches("[fF]"))
                {
                    offSet = 5;
                }
                
                if(note.matches("[fF][#]") || note.matches("[gG][b]"))
                {
                    offSet = 6;
                }
                
                if(note.matches("[gG]"))
                {
                    offSet = 7;
                }
                
                if(note.matches("[gG][#]") || note.matches("[aA][b]"))
                {
                    offSet = 8;
                }
                
                if(note.matches("[aA]"))
                {
                    offSet = 9;
                }
                
                if(note.matches("[aA][#]") || note.matches("[bB][b]"))
                {
                    offSet = 10;
                }
                
                if(note.matches("[bB]") || note.matches("[cC][b]"))
                {
                    offSet = 11;
                }
                
                setOffSet(offSet);
                setBaseNote(note);
                valid_key = true;
            }
            
        }
    }
        
        
    // Sets the class's base note
    public void setBaseNote(String note)
    {
        this.base_note = note;
    }
   
    // Sets the class's offSet
    public void setOffSet(int conversion)
    {
        this.offSet = conversion;
    }
        
        
    // Creates an array of ints that represent the pattern's pitch
    public int[] generatePattern()
    {
        int[] pattern = new int[this.num_notes];
            
        for(int i = 0; i < this.num_notes; i++)
        {
            // Middle C for a base
            int note = 60;
                
            // note = note + octave
            note = note + this.offSet;
            note = note + applyScale(this.scale);
            pattern[i] = note;
                
         }
         
        return pattern;
            
     }
        
        /* We should defer the work of the apply scale method
         * to a scale factory class.
         */
        
    public void getScale()
    {
        String scale = "";
        Scanner scanner = new Scanner(System.in);
        
        boolean valid_scale = false;
        while(!valid_scale)
        {
            System.out.print("Enter a scale\n"
                    + "(major/natural/melodic/harmonic/chromatic/pentatonic): ");
            scale = scanner.nextLine();
            scale.toLowerCase();
            if(scale.equals("major"))
            {
                valid_scale = true;
            }
            
            if(scale.equals("natural"))
            {
                valid_scale = true;
            }
            
            if(scale.equals("melodic"))
            {
                valid_scale = true;
            }
            
            if(scale.equals("harmonic"))
            {
                valid_scale = true;
            }
            
            if(scale.equals("chromatic"))
            {
                valid_scale = true;
            }
            
            if(scale.equals("pentatonic"))
            {
                valid_scale = true;
            }
        }
        
        setScale(scale);
    }
    
    public void setScale(String scale)
    {
        this.scale = scale;
    }
    
    // Adds another offset, based on the scale selected.
    public int applyScale(String scale_type)
    {
        boolean inScale = false;
        Random seed = new Random();
        int app = 0;
            
        if(scale_type.equals("major"))
        {
            while(!inScale)
            {
                app = seed.nextInt(11);
                if(app == 0 || app == 2 || app == 4 || app == 5
                            || app == 7 || app == 9 || app == 11)
                {
                    inScale = true;
                }
             }
         }
            
            if(scale_type.equals("natural"))
            {
               while(!inScale)
               {
                   app = seed.nextInt(11);
                   if(app == 0 || app == 2 || app == 3 || app == 5
                           || app == 7 || app == 8 || app == 10)
                   {
                       inScale = true;
                   }
               }
            }
            
            if(scale_type.equals("melodic"))
            {
                while(!inScale)
                {
                    app = seed.nextInt(11);
                     if(app == 0 || app == 2 || app == 3 || app == 5
                           || app == 7 || app == 9 || app == 11 || app == 8)
                   {
                       inScale = true;
                   }
                }
            }
            
            if(scale_type.equals("harmonic"))
            {
                while(!inScale)
                {    app = seed.nextInt(11);
                    if(app == 2 || app == 3 || app == 5 || app == 7
                        || app == 8 || app == 11)
                    {
                        inScale = true;
                    }
                }
            }
            
            if(scale_type.equals("chromatic"))
            {
                app = seed.nextInt(11);
            }
            
            if(scale_type.equals("pentatonic"))
            {
                while(!inScale)
                {
                    app = seed.nextInt(11);
                    if(app == 2 || app == 5 || app == 7 || app == 9)
                    {
                        inScale = true;
                    }
                }
            }
            
            // App is a random note in scale
            return app;
        }
}
