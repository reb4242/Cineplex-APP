/**
 * This is a subclass of Viewing. For a standard movie viewing. 
 *
 * @author (Rebecca)
 * @version (Jan.11st/24)
 */
public class Standard extends Viewing{
    //declare variables
    private boolean bolStandard;
        //whether this viewing is a Standard format
    
    //constructors
    public Standard(){
        //call default constructor from super class
        super();
        
        //initialize variables
        this.bolStandard = true;
    }
    public Standard(byte h, byte m, boolean s){
                    //parameters: showtime, whether Standard
        //call default constructor from super class
        super(h, m);
        
        //initialize variables
        this.bolStandard = s;
    }
    
    @Override
    public String getType(){
        //return statement
        return "Standard";
    }
}
