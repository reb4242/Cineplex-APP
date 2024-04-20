/**
 * This is the Main class of the program. 
 * Main objectives: 
 * - creates all Movie objects and stores them within the database
 * - read and write information to files in order to be used throughout every run
 * - holds different features of the program together
 * 
 * @author (Rebecca)
 * @version (Jan.10th/24)
 */
//import arralist package
import java.util.ArrayList;
//import JOptionPane package
import javax.swing.JOptionPane;
//import File IO library
import java.io.*;
//import all java util library
import java.util.*;
// Needed for use of Scanner and NoSuchElementException
public class Main{
    //declare variables
    private static Byte bytInput;
        //a temporary variable to hold any byte input from the user before further use
    private static String strInput;
        //a temporary variable to hold any string input from the user before further use
    private static char chrInput, chrSeatX;
        //chrInput: a temporary variable to hold any char input from the user before further use
        //chrSeatX: to hold the char value of a seat, ex: A from A1
    private static Byte bytSeatX, bytSeatY;
        //bytSeatX: the index of the char value of a seat in terms of the alphabet, ex: A as 0
        //bytSeatY: the numerical value of a seat, ex: 1 from A1
    private static Movie MovieCurrent;
        //a variable to hold the current Movie object the user is interacting with
    private static Viewing ViewingCurrent;
        //a variable to hold the current Viewing object the user is interacting with
    private static boolean bolBack = false;
        //to store whether the user wish to loop back to the previous page
    private static boolean bolFlag = true;
        //to store whether looping again is necessary - used for error traping
    private static ArrayList<Movie> MovieArrDatabase = new ArrayList<Movie>();
        //an arraylist of all Movie objects offered by Cinebex Movies
    private static int intTicketsSold;
        //a variable to hold the number of tickets ever sold/printed - value read from file
    
    //declare scanners
    private static Scanner ByteInput = new Scanner(System.in);
        //a scanner only for byte input - to prevent an empty scanner between string inputs
    private static Scanner StringInput = new Scanner(System.in);
        //a scanner only for string input - to prevent an empty scanner between byte inputs
    
    public static void Main(String[] args){
        //create Movies and Viewings and store in database arraylist
            //create Movies
                //parameters: movie title, rating, length of movie in minutes, list of genres, description of movie 
            Movie m1 = new Movie("Mean Girls (2024)", "PG ", (short)112, "Comedy, Musical", "Cady Heron is a hit with the Plastics, an A-list girl \nclique at her new school. But everything changes when \nshe makes the mistake of falling for Aaron Samuels, \nthe ex-boyfriend of alpha Plastic Regina George.");
            Movie m2 = new Movie("The Beekeeper", "14A", (short)106, "Action", "In The Beekeeper, one man’s brutal campaign for \nvengeance takes on national stakes after he is revealed \nto be a former operative of a powerful and clandestine \norganization known as “Beekeeper's.”");
            Movie m3 = new Movie("Migration", " G  ", (short)91, "Action, Animation, Comedy", "A family of ducks try to convince their overprotective \nfather to go on the vacation of a lifetime.");
        
            //add Movie objects to arraylist of movies
            MovieArrDatabase.add(m1);
            MovieArrDatabase.add(m2);
            MovieArrDatabase.add(m3);
            
            //create Viewings
                //parameters: hour of showtime as a byte, minute of showtime as a byte, boolean whether type of viewing is true
            Standard v1 = new Standard((byte)19, (byte)10, true);
            Standard v2 = new Standard((byte)21, (byte)50, true);
            Standard v3 = new Standard((byte)13, (byte)10, true);
            IMAX v4 = new IMAX((byte)16, (byte)45, true);
            ThreeD v5 = new ThreeD((byte)18, (byte)20, true);
            ThreeD v6 = new ThreeD((byte)20, (byte)50, true);
            
            //add Viewing objects to each movie
            m1.AddViewings(v1);
            m1.AddViewings(v2);
            m2.AddViewings(v3);
            m2.AddViewings(v4);
            m3.AddViewings(v5);
            m3.AddViewings(v6);
            
            //update each seating plan by reading from files
                //parameters: seating plan object, name of text file to read from
            ReadSeatingPlan(v1.getPlan().getArrPlan(), (m1.getTitle() + v1.getShowtimeHour() + v1.getShowtimeMin() + ".txt"));
            ReadSeatingPlan(v2.getPlan().getArrPlan(), (m1.getTitle() + v2.getShowtimeHour() + v2.getShowtimeMin() + ".txt"));
            ReadSeatingPlan(v3.getPlan().getArrPlan(), (m2.getTitle() + v3.getShowtimeHour() + v3.getShowtimeMin() + ".txt"));
            ReadSeatingPlan(v4.getPlan().getArrPlan(), (m2.getTitle() + v4.getShowtimeHour() + v4.getShowtimeMin() + ".txt"));
            ReadSeatingPlan(v5.getPlan().getArrPlan(), (m3.getTitle() + v5.getShowtimeHour() + v5.getShowtimeMin() + ".txt"));
            ReadSeatingPlan(v6.getPlan().getArrPlan(), (m3.getTitle() + v6.getShowtimeHour() + v6.getShowtimeMin() + ".txt"));
        
        do{
            do{
                do{
                    //reset bolBack so don't infinity loop
                    bolBack = false;
                    
                    //intro
                    System.out.println("Cinebex Movies");
                    System.out.println();
                    
                    //output movie choices offered this day
                    System.out.println("Picks for the day: ");
                    for(byte index = 0; index < MovieArrDatabase.size(); index++){
                                                //loop until the last index of the arraylist of database
                        //output the menu choice
                        System.out.println((index + 1)+ " - " + MovieArrDatabase.get(index).getTitle());
                                            //choice start at zero instead of 1
                    }
                    
                    do{
                        //reset bolFlag
                        bolFlag = true;
                            
                        try{
                            //get user input for which movie to watch
                            bytInput = ByteInput.nextByte();
                        
                            //check if input is actually a number offer by the menu
                            if(bytInput < 1 || bytInput > 4){
                                //run here when input is not offered
                                
                                //set flag to loop again
                                bolFlag = false;
                                //message to user
                                System.out.println("Please enter an integer offered by the menu! ex: 1");
                            }
                        }catch(Exception e){
                            //run here when input is not a byte
                                
                            //set flag to loop again
                            bolFlag = false;
                            //message to user
                            System.out.println("Please enter an integer offered by the menu! ex: 1");
                            //clears the scanner
                            ByteInput.nextLine();
                                //since a non-numerical value will crash the scanner
                        }
                    }while(bolFlag == false);
                        //loop while the user input is not a byte of a byte that is offered
                    
                    //interpret user input
                    switch(bytInput){
                        //set the Movie the user is currently interacting with
                        case 1: MovieCurrent = m1; break;
                        case 2: MovieCurrent = m2; break;
                        case 3: MovieCurrent = m3; break;
                    }
                    
                    //clear terminal window for visual purposes
                    Clear();
                    
                    
                    
                    //second page
                    //output the movie user wish to view
                    System.out.println(MovieCurrent.toString());
                                        //call toString method from Movie object
                                 
                    //visual purposes
                    System.out.println();
                    
                    //output GetTicket menu
                    System.out.println("1 - Get Tickets");
                    System.out.println("2 - Back");
                    
                    do{
                        //reset bolFlag
                        bolFlag = true;
                        try{
                            //get user input for which movie to watch
                            bytInput = ByteInput.nextByte();
                            
                            //check if input is actually a number offer by the menu
                            if(bytInput < 1 || bytInput > 2){
                                //run here when input is not offered
                                
                                //set flag to loop again
                                bolFlag = false;
                                //message to user
                                System.out.println("Please enter an integer offered by the menu! ex: 1");
                            }
                        }catch(Exception e){
                            //set flag to loop again
                            bolFlag = false;
                            //message to user
                            System.out.println("Please enter an integer offered by the menu! ex: 1");
                            //clears the scanner
                            ByteInput.nextLine();
                                //since a non-numerical value will crash the scanner
                        }
                    }while(bolFlag == false);
                            //loop while the user input is not a byte of a byte that is offered

                    //visual purposes
                    Clear();
                    
                    //interpret input
                    switch(bytInput){
                        case 1: System.out.println("Showtimes today: "); ViewViewings(MovieCurrent); break;
                            //output Viewings of the movie the user is currently interacting with
                        case 2: bolBack = true; break; 
                    }
                }while(bolBack == true);
                    //loop while the user wish to go back to the previous page
                
                    
                //third page
                //output the back choice
                System.out.println("3 - Home");
                    //the showtimes are already outputted above
                
                do{
                    //reset bolFlag
                    bolFlag = true;
                    try{
                        //get user input for which showtime to proceed with
                        bytInput = ByteInput.nextByte();
                        
                        //check if input is actually a number offer by the menu
                        if(bytInput < 1 || bytInput > 3){
                            //run here if input is not offered
                            
                            //set flag to loop again
                            bolFlag = false;
                            //message to user
                            System.out.println("Please enter an integer offered by the menu! ex: 1");
                        }
                    }catch(Exception e){
                        //run here if input is not a numerical value
                        
                        //set flag to loop again
                        bolFlag = false;
                        //message to user
                        System.out.println("Please enter an integer offered by the menu! ex: 1");
                        //clears the scanner
                        ByteInput.nextLine();
                            //since a non-numerical value will crash the scanner
                    }
                }while(bolFlag == false); 
                    //loop while input is not a numerical value that is offered by the menu
            
                //interpret user input
                switch(bytInput){
                    case 1: ViewingCurrent = MovieCurrent.getViewings().get(0); break;
                        //store Viewing object the user is currently interacting with
                    case 2: ViewingCurrent = MovieCurrent.getViewings().get(1); break;
                        //store Viewing object the user is currently interacting with
                    case 3: bolBack = true; break;
                }
                
                //visual purposes
                Clear();
            }while(bolBack == true);
                    //loop while user wish to go to home page
            
            do{
                //visual purposes
                Clear();
                
                //output the seating plan
                ViewingCurrent.getPlan().ViewPlan();
                    //Viewing object --> 2D array --> method to output the seating plan
            
                //reset bolFlag
                bolFlag = false;
                
                //select seating: the row
                System.out.println("Which row would you like to choose? ex: A");
                do{
                    //reset bolFlag
                    bolFlag = false;
                    
                    //get user input for which showtime to proceed with
                    chrInput = StringInput.nextLine().charAt(0);
                        
                    //check if input is actually a letter offer by the seatin plan
                    for(byte index = 0; index < ViewingCurrent.getPlan().getAlpha().length; index++){
                                                //Viewing object --> 2D array --> array of Alphabets offered in seating plan
                        if(Character.toUpperCase(chrInput) == ViewingCurrent.getPlan().getAlpha()[index]){
                            //set character to uppercase
                            
                            //if char input is a letter offered in the seating plan
                            bolFlag = true;
                        }
                    }
                        
                    //whether letter is offered
                    if(bolFlag == false){
                        //run here when letter is not offered
                        System.out.println("Please input a letter that is offered in the seating plan. ex: A");
                    }
                }while(bolFlag == false);
                    //loop while letter is not offered 
                
                //select seating: the column
                System.out.println("Which column would you like to choose? ex: 1");
                do{
                    //reset bolFlag
                    bolFlag = true;
                    try{
                        //get user input for which showtime to proceed with
                        bytInput = ByteInput.nextByte();
                        
                        //check if input is actually a number offer by the seatin plan
                        if((bytInput < 1) || (bytInput > 10)){
                            bolFlag = false;
                            System.out.println("Please input an integer that is offered in the seating plan. ex: 1");
                        }
                    }catch(Exception e){
                        bolFlag = false;
                        System.out.println("Please input an integer that is offered in the seating plan. ex: 1");
                        //clears the scanner
                        ByteInput.nextLine();
                    }
                }while(bolFlag == false);
                
                //update coordinate of the seat - turn char to uppercase
                chrSeatX = Character.toUpperCase(chrInput);
                
                //update coordinates for 2D array seating plan
                bytSeatX = ReturnAlphaIndex(chrInput);
                bytSeatY = (byte)(bytInput - 1);
                            //minus one because index in arraylist starts at 0
                
                //check if seat is already taken
                if(ViewingCurrent.getPlan().getArrPlan()[bytSeatX][bytSeatY] == 'x'){
                    bolFlag = false;
                    JOptionPane.showMessageDialog(null, chrSeatX + "" + (bytSeatY + 1) + " is taken already. Please select another seat. ");
                }
            }while(bolFlag == false);
            
            //confirm message before updating the seating plan
            bytInput = (byte)(JOptionPane.showConfirmDialog(null, "Please confirm your seat: " + chrSeatX + (bytSeatY + 1)));
            
            //interpret user input
            if(bytInput == 0){
                    //"Yes" was pressed
                //update the seating plan
                ViewingCurrent.getPlan().getArrPlan()[bytSeatX][bytSeatY] = 'x';
                //update the seating chart by printing it to a file
                WriteSeatingPlan(ViewingCurrent.getPlan().getArrPlan());
            } else if(bytInput == 1){
                    //"No" was pressed
                JOptionPane.showMessageDialog(null, "Please exit the program and try again!");
                System.exit(0);
            } else if(bytInput == 2){
                    //"Cancel" was pressed
                JOptionPane.showMessageDialog(null, "Please exit the program and try again!");
                System.exit(0);
            }
            
            //generate ticket
            //create a Ticket object
            Ticket t1 = new Ticket(chrSeatX, (byte)(bytSeatY + 1));
            //write ticket to file
            WriteTicket(t1, MovieCurrent, ViewingCurrent);
            
            //visual purposes
            Clear();
            
            //message to user
            System.out.println("Your ticket is printed to file " + "Ticket#" + t1.getID() + ".txt");
            
            //visual purposes
            System.out.println();
            
            //offer menu
            System.out.println("Menu:");
            System.out.println("1 - Home");
            System.out.println("2 - Exit");
            do{
                //reset bolFlag
                bolFlag = true;
                try{
                    //get user input for which showtime to proceed with
                    bytInput = ByteInput.nextByte();
                    
                    //check if input is offered from the menu
                    if(bytInput < 1 || bytInput > 2){
                        bolFlag = false;
                        System.out.println("Please enter an integer offered by the menu!");
                    }
                }catch(Exception e){
                    bolFlag = false;
                    System.out.println("Please enter an integer offered by the menu!");
                    //clears the scanner
                    ByteInput.nextLine();
                }
            }while(bolFlag == false);
                
            //reset bolBack
            bolBack = false;
            
            //visual purposes
            Clear();
            
            //interpret user input
            switch(bytInput){
                case 1: bolBack = true; break;
                case 2: System.out.println("Thank you for choosing Cinebex Movies");
                System.out.println("Have a great day!");
                System.exit(0); break;
            }
        }while(bolBack = true);
    }
    
    //write seating chart to a file
    private static void WriteSeatingPlan(char[][] p){
                                        //parameter: the 2D array of seating plan
        try {
            //create PrintWriter to write to a file
            PrintWriter out = new PrintWriter(new FileWriter(MovieCurrent.getTitle() + ViewingCurrent.getShowtimeHour() + ViewingCurrent.getShowtimeMin() + ".txt"));
            
            //write to the file
            //loop through the rows of seating plan
            for(byte Row = 0; Row < p.length; Row++){
                //loop through the columns of seating plan
                for(byte Col = 0; Col < p[0].length; Col++){
                    out.print(p[Row][Col]);
                }
                out.println();
            }
            
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
    private static void ReadSeatingPlan(char[][] p, String f){
        //read the file by using scanners
        //map reading
        try {
            //create scanner
            Scanner in = new Scanner(new FileReader(f));
                
            //read from file
            for (byte Row = 0; Row < p.length; Row++){
                String strRow = in.nextLine();
                //loop through the columns
                for(byte Col = 0; Col < p[0].length; Col++){
                    p[Row][Col] = strRow.charAt(Col);
                }
                //reset value read from each row
                strRow = "";
            }
                
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
    
    //write seating chart to a file
    private static void WriteTicket(Ticket t, Movie m, Viewing v){
        
        try {
            //create PrintWriter to write to a file
            PrintWriter out = new PrintWriter(new FileWriter("Ticket#" + t.getID() + ".txt"));
            
            //write to the file
                //48 stars across
            out.println("************************************************");
            out.println("*                Cinebex Movies                *");
            out.println("*  ------------------------------------------  *");
            out.println("* " + t.getDate() + ReturnSpace("" + t.getDate(), (byte)0) + "*");
            out.println("* " + m.getTitle() + ReturnSpace(m.getTitle(), (byte)0) + "*");
            out.println("* Type: " + v.getType() + " Rated: " + m.getRating() + ReturnSpace(v.getType() + m.getRating(), (byte)14) + "*");
            out.println("* Showtime: Today " + v.toString() + ReturnSpace(v.toString(), (byte)16) + "*");
            out.println("* Seat: " + t.getSeat() + ReturnSpace(t.getSeat(), (byte)6) + "*");
            out.println("*              Enjoy your viewing!             *");
            out.println("************************************************");
            
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
    
    //method to calculate the length of string
    private static String ReturnSpace(String s, byte b){
        //declare variables
        String strSpaces = "";
        for(byte index = (byte)((45 - b) - s.length()); index > 0; index--){
            strSpaces += " ";
        }
        
        return strSpaces;
    } 
    
    //return type of Viewing
    private static String ReturnViewingType(Viewing v){
        return v.getType();
    }
    
    //return index of char in alphabet
    private static byte ReturnAlphaIndex(char c){
        //search through alphabet
        for(byte index = 0; index < ViewingCurrent.getPlan().getAlpha().length; index++){
            if(Character.toUpperCase(c) == ViewingCurrent.getPlan().getAlpha()[index]){
                return index;
            }
        }
        return 0;
    }
    
    //output viewings
    private static void ViewViewings(Movie m){
        for(byte index = 0; index < m.getViewings().size(); index++){
            System.out.println((index + 1) + " - " + m.getViewings().get(index));
                                //choice start at zero instead of 1
        }
    }
    
    private static void Clear(){
        System.out.print('\u000c');
    }
}
