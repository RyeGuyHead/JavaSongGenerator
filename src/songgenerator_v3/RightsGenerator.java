package songgenerator_v3;

/**
 * This class has to do with file information
 * and is not important in this version
 * 
 * @author ryanjohnson
 * @version 1.3
 */

import java.util.*;

public class RightsGenerator {
    
    String owner;
    String date;
    String title;
    
    public RightsGenerator()
    {        
    }
    
    public void getOwner()
    {
        System.out.print("What is your name: ");
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        setOwner(in);
        
    }
    
    public void setOwner(String owner)
    {
        this.owner = owner;
    }
    
    public void getDate()
    {
        System.out.print("What is today's date: ");
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        setDate(in);
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public void getTitle()
    {
        System.out.print("Title of the piece: ");
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        setTitle(in);
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
}
