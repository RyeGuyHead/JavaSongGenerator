package songgenerator_v3;

/**
 * This is the driver for the program
 * 
 * Simple random note generator based on
 * user input. Uses the default midi sound driver to
 * select an instrument and user channel.noteOn and
 * channel.noteOff methods to play sound
 * 
 *  
 * @author ryanjohnson
 * @version 1.3
 */

import javax.sound.midi.*;
import java.util.*;

public class SongGenerator_V3{

    private static MidiChannel       channel;
    public static void main(String[] args) throws Exception{
        
        // All of this code sets up the default midi sound bank and synth
        
        MidiChannel[]   channels;
	Soundbank       defaultSB;
	Synthesizer     synthesizer;
        
        Scanner scanner = new Scanner(System.in);
        
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        
        defaultSB = synthesizer.getDefaultSoundbank();
	synthesizer.loadAllInstruments(defaultSB);
	channels    = synthesizer.getChannels();
        
        channel = channels[0];
        
        /** This stuff is about the basic song features
         *  and isn't really that relevant at the moment.
         * 
         *  Once there a file is made, this information
         *  will be more important.
         
        
        RightsGenerator rights = new RightsGenerator();
        
        rights.getOwner();
        rights.getDate();
        rights.getTitle();
        
        MeterGenerator meter = new MeterGenerator();
        
        meter.getTempo();
        meter.getBeatsPerMeasure();
        meter.getlengthOfBeat();
        meter.getStyle();
        
        System.out.println("Your song information:\n ");
        
        System.out.println("Artist: " + rights.owner);
        System.out.println("Date: " + rights.date);
        System.out.println("Title: " + rights.title);
        
        System.out.println("Tempo: " + meter.tempo);
        System.out.println("Time Signature: " + meter.length_of_beat + "/" + meter.beats_per_measure);
        System.out.println("Style: " + meter.style);
        
        */
       
        
        // Random number generator for note length and velocity levels
        Random dynamics = new Random();
        
        PatternGenerator pg = new PatternGenerator();
        StyleGenerator sg = new StyleGenerator();
        
        pg.getBaseNote();
        pg.getScale();
        pg.getNumNotes();
        
        // Creates a pattern of music based on the scale and root
        int[] instrumentPattern = pg.generatePattern();
        
        //sg.getInstrument(); will eventually pick an instrument
        //based on chosen song style.
    
        // Select an instrument from the synthesizer's soundbank
        int instrument;
        System.out.print("Pick an instrument(number): ");
        instrument = scanner.nextInt();
        channel.programChange(0, instrument);
        
        // Select the number of times you want to play the pattern
        int loops = 1;
        boolean isValid = false;
    
        while(!isValid)
        {
            System.out.print("Loop(1-4): ");
            loops = scanner.nextInt();
            if(loops > 0 && loops < 5)
            {
                isValid = true;
            }
        }
        
        // Loop the pattern
        while(loops > 0)
        {
            // My play method
            for(int j = 0; j < pg.num_notes; j ++)
            {
                channel.noteOn(instrumentPattern[j], (70 + dynamics.nextInt(57)));
            
                // Plays for a random length(this number can be user generated)
                Thread.sleep((300 + ((dynamics.nextInt(500) / 100) * 100)));
                channel.noteOff(instrumentPattern[j]);
                
            }
            
            loops -= 1;
        }
    }
}
