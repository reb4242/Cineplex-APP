/**
 * This is the Movie class. 
 * Main objectives: 
 * - as a blueprint of each Movie object
 * - add Viewings to arraylist
 *
 * @author (Rebecca)
 * @version (Jan.10th/24)
 */
//import arralist package
import java.util.ArrayList;
public class Movie{
    //delcare variables
    private String strTitle; 
        //movie name
    private String strRating;
        //rating of movie, ex:PG
    private short shrLength;
        //length of movie in minutes
    private String strGenre;
        //list of genres this movie falls into
    private String strDescription;
        //a short description for the movie
    private ArrayList<Viewing> ViewingArrViewings;
        //an arraylist of all showtimes avaliable of the day
    
    //constructors
    public Movie(){
        //initialize all variables
        this.strTitle = "UNKNOWN";
        this.strRating = "UNKNOWN";
        this.shrLength = 0;
        this.strGenre = "UNKNOWN";
        this.strDescription = "EMPTY";
        this.ViewingArrViewings = new ArrayList<Viewing>();
            //initialize an empty arraylist
    }
    public Movie(String t, String r, short l, String g, String d){
                //parameters: movie title, rating, length of movie, list of genres, description
        //initialize all variables
        this.strTitle = t;
        this.strRating = r;
        this.shrLength = l;
        this.strGenre = g;
        this.strDescription = d;
        this.ViewingArrViewings = new ArrayList<Viewing>();
            //initialize an empty arraylist
    }
    
    //add viewings to this movie
    public void AddViewings(Viewing v){
                //parameter: a Viewing object for this movie
        //add another element to arraylist of available showtimes
        this.ViewingArrViewings.add(v);
    }
    
    //toString - to output information of a Movie in a formatted way
    public String toString(){
        //return statement
        return String.format("%s\n    Length    Rating    Genre\n    %d       %s       %s\n\n%s", this.strTitle, this.shrLength, this.strRating, this.strGenre, this.strDescription);
    }
    
    //getters - return a value when called
    public String getTitle(){
        //return statement
        return this.strTitle;
    }
    public ArrayList<Viewing> getViewings(){
        //return statement
        return this.ViewingArrViewings;
    }
    public String getRating(){
        //return statement
        return this.strRating;
    }
}
