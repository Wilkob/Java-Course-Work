
/**
 * Write a description of class Shuttle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shuttle
{
    // instance variables - replace the example below with your own
    private String JourneyCode; 
    private World SourceWorld;
    private World DestinationWorld;

    /**
     * Constructor for objects of class Shuttle
     */
    public Shuttle(String injourneycode,World insourceworld,World indestinationworld)
    {
        // initialise instance variables
     JourneyCode = injourneycode; 
     SourceWorld = insourceworld;
     DestinationWorld = indestinationworld;        
    }

    public boolean checkJourneyCode(String MaybeCode){
        if (MaybeCode .equals(JourneyCode.replaceAll("\\P{Print}",""))){
            return true;
        }
        else {
        return false;
        }
    }
    
    public String getJourneyCode()
    {
        return JourneyCode;
    }
    
    public World checkSourceWorld()
    {
        return SourceWorld;
    }
    
    public World checkDestinationWorld()
    {
        return DestinationWorld;
    }
    
        public void changeJourneyCode(String NewCode)
    {
            JourneyCode = NewCode;
    }
    
            public void changeDesWorld(World NewWorld)
    {
            DestinationWorld = NewWorld;
    }
    
    public void changeSourceWorld(World NewWorld)
    {
            SourceWorld = NewWorld;
    }
    
    public boolean checkTravel(Card Guest)
    {
        if (Guest.checkRide() != true  || DestinationWorld.checkAtCap() != true || SourceWorld.findCardById(Guest.accessID()) != true )
        {
          
        return false;
    }
    else if (Guest.accessRating() >= DestinationWorld.checkRating())
    {
        return true;
    }
    else {
        return false;}
    }
    
    public String AttemptTravel (Card Guest)
    {
        if (checkTravel(Guest) == true)
        {
            Guest.spendCredits(3);
            Guest.addPoints(2);
            SourceWorld.leave(Guest);
            DestinationWorld.enter(Guest);
            return ("Guest "+ Guest.accessID() +" has travelled to world " + DestinationWorld.getName());
        }
        else {return ("Error Guest " + Guest.accessID() + " cannot travel to world " + DestinationWorld.getName());}
    }
                public String toString()
    {
        String s = "****************" + "\n*  Shuttles Details";
        s = s + "\n*  Journey Code: " + JourneyCode + "\n*  Start World : " ;
        s = s + SourceWorld.getName() + "\n* Destination World : " 
              +  DestinationWorld.getName();
        s = s + "\n*****************";
        return s;
    }
}
