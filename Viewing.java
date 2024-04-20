/**
 * This is the Viewing class. 
 * Main objectives: 
 * - as a blueprint for each Viewing object, including showtimes
 * - as a super class of Standard, ThreeD, and IMAX
 *
 * @author (Rebecca)
 * @version (Jan.10th/24)
 */
public class Viewing{
    //declare variables
    private byte bytShowtimeHour, bytShowtimeMin;
        //the hour of the movie show time
    private Seating stnPlan; 
        //a Seating object that holds a 2D array plan
    
    //constructors
    public Viewing(){
        //initialize variables
        this.bytShowtimeHour = 00;
        this.bytShowtimeMin = 00;
        this.stnPlan = new Seating();
    }
    public Viewing(byte h, byte m){
        //initialize variables
        this.bytShowtimeHour = h;
        this.bytShowtimeMin = m;
        this.stnPlan = new Seating();
    }
    
    //toString 
    public String toString(){
        return this.bytShowtimeHour + ":" + bytShowtimeMin;
    }
    
    //getter
    public byte getShowtimeHour(){
        //return statement
        return this.bytShowtimeHour;
    }
    public byte getShowtimeMin(){
        //return statement
        return this.bytShowtimeMin;
    }
    public Seating getPlan(){
        //return statement
        return this.stnPlan;
    }
    public String getType(){
        //return statement
        return "Viewing";
    }
}
