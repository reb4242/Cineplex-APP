/**
 * This is a subclass of Viewing. For a 3D movie viewing. 
 *
 * @author (Rebecca)
 * @version (Jan.11st/24)
 */
public class ThreeD extends Viewing{
    //declare variables
    private boolean bolThreeD;
        //whether this viewing is a 3D format
    
    //constructors
    public ThreeD(){
        //call default constructor from super class
        super();
        
        //initialize variables
        this.bolThreeD = true;
    }
    public ThreeD(byte h, byte m, boolean t){
                 //parameters: showtime, whether 3D
        //call default constructor from super class
        super(h, m);
        
        //initialize variables
        this.bolThreeD = t;
    }
    
    //getter
    @Override
    public String getType(){
        //return statement
        return "ThreeD";
    }
}
