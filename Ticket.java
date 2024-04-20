/**
 * This is the Ticket class.
 * Main objectives: 
 * - as a blueprint for each Ticket object
 * - read and write the number of tickets ever sold
 *
 * @author (Rebecca)
 * @version (Jan.16th/23)
 */
//import Date library
import java.util.Date;
//import File IO library
import java.io.*;
//import all java util library
import java.util.*;
// Needed for use of Scanner and NoSuchElementException
public class Ticket{
    //declare variables
    private char chrSeat;
    private byte bytSeat;
        private Date datPurchased;
    private int intTicketID;
    private static int intTicketsSold;
    
    //counter method to tally up total amount of tickets
    private static int TicketCounter(){
        intTicketsSold += 1;
        WriteTicketsSold();
        return intTicketsSold;
    }
    
    //constructors
    public Ticket(){
        //initialize all variables
        this.chrSeat = ' ';
        this.bytSeat = 0;
        this.datPurchased = new Date();
        ReadTicketsSold();
        this.intTicketID = TicketCounter();
            //call counter method to tally up total amount of tickets
    }
    public Ticket(char s, byte n){
        //initialize all variables
        this.chrSeat = s;
        this.bytSeat = n;
        this.datPurchased = new Date();
        ReadTicketsSold();
        this.intTicketID = TicketCounter();
            //call counter method to tally up total amount of tickets
    }
    
    //write number of tickets sold to a file
    private static void WriteTicketsSold(){
        try {
            //create PrintWriter to write to a file
            PrintWriter out = new PrintWriter(new FileWriter("TicketsSold.txt"));
            
            //write to the file
            out.print(intTicketsSold);
            
            //close file when done to prevent runtime errors
            out.close();
        } catch (FileNotFoundException e) {
            //file not found
            System.out.println("Error: Cannot open file for writing");
        } catch (IOException e) {
            //no read and write rights for the file
            System.out.println("Error: Cannot write to file");
        }
    }
    //read seating chart to a file
    private static void ReadTicketsSold(){
        //read the file by using scanners
        //map reading
        try {
            //create scanner
            Scanner in = new Scanner(new FileReader("TicketsSold.txt"));
                
            //read from file
            intTicketsSold = in.nextInt();
            
            //close file when done to prevent runtime errors
            in.close();
        } catch (FileNotFoundException e){
            //file not found
            //System.out.println("Error: Cannot open file for reading");
        } catch (NoSuchElementException e){
            //file found, cannot be read
            System.out.println("Error: EOF encountered, file may be corrupt");
        } catch (IOException e){
            //no read and write rights for the file
            System.out.println("Error: Cannot read from file");
        }
    }
    
    //getters
    public int getID(){
        //return statement
        return this.intTicketID;
    }
    public Date getDate(){
        //return statement
        return this.datPurchased;
    }
    public String getSeat(){
        //return statement
        return "" + this.chrSeat + this.bytSeat;
    }
}
