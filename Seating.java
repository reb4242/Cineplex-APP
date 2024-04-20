/**
 * This is the Seating class. 
 * Main objectives: 
 * - as a blueprint for each Seating object
 *
 * @author (Rebecca)
 * @version (Jan.11st/24)
 */
//import File IO library
import java.io.*;
public class Seating{
    //declare variables
    private char[][] chrArrPlan;
        //a 2D array to store the seating plan
    private char[] chrArrAlpha = {'A', 'B', 'C', 'D', 'E'};
        //an array of alphabets, for PrintAlpha();
        
    //constructors
    public Seating(){
        //initialize variables
        this.chrArrPlan = new char[5][10];
        
        //populate array
        CreatePlan();
    }
    
    //create map
    public void CreatePlan(){
        //populate the array with empty spaces
        //loop through the rows of seating plan
        for(byte Row = 0; Row < this.chrArrPlan.length; Row++){
            //loop through the columns of seating plan
            for(byte Col = 0; Col < this.chrArrPlan[0].length; Col++){
                this.chrArrPlan[Row][Col] = ' ';
            }
        }
    }
    
    //to output the seating plan
    public void ViewPlan(){
        System.out.println("     1   2   3   4   5   6   7   8   9  10");
        System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
        //loop through the rows of seating plan
        for(byte Row = 0; Row < this.chrArrPlan.length; Row++){
            System.out.print(" " + PrintAlpha((byte)(Row)) + " | ");
                                    //call helper method to print the letter of the row
            //loop through the columns of seating plan
            for(byte Col = 0; Col < this.chrArrPlan[0].length; Col++){
                System.out.print(this.chrArrPlan[Row][Col] + " | ");
            }
            //start a new line
            System.out.println("\n   +---+---+---+---+---+---+---+---+---+---+");
        }
    }
    
    //print alphabet - helper method for ViewPlan()
    private char PrintAlpha(byte bytIndex){
                            //parameters: the index of the nth letter in the alphabet    
        //return corresponding letter based on index
        return chrArrAlpha[bytIndex];
    }
    
    //getter
    public char[] getAlpha(){
        //return statement
        return this.chrArrAlpha;
    }
    public char[][] getArrPlan(){
        //return statement
        return this.chrArrPlan;
    }
}
