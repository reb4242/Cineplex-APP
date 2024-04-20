/**
 * This is a subclass of Viewing. For an IMAM movie viewing. 
 *
 * @author (Rebecca)
 * @version (Jan.11st/24)
 */
public class IMAX extends Viewing{
    //declare variables
    private boolean bolIMAX;
        //whether this viewing is a IMAX format
    
    //constructors
    public IMAX(){
        //call default constructor from super class
        super();
        
        //initialize variables
        this.bolIMAX = true;
    }
    public IMAX(byte h, byte m, boolean i){
                //parameters: showtime, whether IMAX
        //call default constructor from super class
        super(h, m);
        
        //initialize variables
        this.bolIMAX = i;
    }
    
    //getter
    @Override
    public String getType(){
        //return statement
        return "IMAX";
    }
}
