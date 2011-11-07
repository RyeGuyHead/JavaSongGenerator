package songgenerator_v3;

/**
 * Largely unimportant and not commented at this point
 * 
 * @author ryanjohnson
 * @version 1.3
 *
 */

import java.util.*;

public class MeterGenerator {
    int tempo;
    int beats_per_measure;
    int length_of_beat;
    String style;
    
    public MeterGenerator()
    {
        
    }
    
    public void getTempo()
    {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        int tempo = 0;
        while(!isInt)
        {
            System.out.print("Enter the tempo you want: ");
            try 
            {
                tempo = scanner.nextInt();
                
                if (tempo > 0)
                {
                    isInt = true;
                    setTempo(tempo);
                }
                else
                {
                    System.out.println("Enter a number larger than zero");
                }
            
            }
            catch(InputMismatchException e)
            {
                System.out.println("Words like 'fast' and such are not supported yet.");
                System.out.println("Please try again and enter a number...sorry for the inconveinnce!");
                System.exit(0);
            }
            

        }
    }
    
    public void setTempo(int tempo)
    {
        this.tempo = tempo;
    }
    
    
    public void getBeatsPerMeasure()
    {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        int beats_per_measure = 0;
        while(!isInt)
        {
            System.out.print("Enter the beats per measure that you want: ");
            try 
            {
                beats_per_measure = scanner.nextInt();
                
                if (beats_per_measure > 0)
                {
                    isInt = true;
                    setBeatsPerMeasure(beats_per_measure);
                }
                else
                {
                    System.out.println("Enter a number larger than zero");
                }
            
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please try again and enter a number...sorry for the inconveinnce!");
                System.exit(0);
            }
            

        }
    }
    
    public void setBeatsPerMeasure(int beats_per_measure)
    {
        this.beats_per_measure = beats_per_measure;
    }
    
    public void getlengthOfBeat()
    {
        Scanner scanner = new Scanner(System.in);
        int length_of_beat = 0;
        boolean isInt = false;
        
        while(!isInt)
        {
            System.out.print("Enter the length of each beat (4 = quarter note): ");
            
            try
            {
                length_of_beat = scanner.nextInt();
                
                if(length_of_beat > 0)
                {
                    setLengthOfBeat(length_of_beat);
                    isInt = true;
                }
                
                else
                {
                    System.out.println("Enter a number larger than zero!");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please try again and enter a number...sorry for the inconveinnce!");
                System.exit(0);
            }
         
        }
    }
    
    public void setLengthOfBeat(int length_of_beat)
    {
        this.length_of_beat = length_of_beat;
    }
    
    public void getStyle()
    {
        Scanner scanner = new Scanner(System.in);
        String style;
        System.out.print("Enter the style you want: ");
        style = scanner.nextLine();
        setStyle(style);
    }
    
    public void setStyle(String style)
    {
        this.style = style;
    }
}
