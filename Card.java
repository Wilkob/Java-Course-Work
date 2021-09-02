
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int ID;
    private String Name;
    private int LuxuryRating;
    private int NumCredits;
    private int NumLoyaltyPoints;

    /**
     * Constructor for objects of class Card
     */
    public Card(int inID, String inName, int inLuxuryRating,int inNumCredits)
    {
            ID = inID;
            Name = inName;
            LuxuryRating = inLuxuryRating;
            NumCredits = inNumCredits;
            NumLoyaltyPoints = 0;
    }
    public void addCredits(int Num)
    {

            NumCredits = NumCredits + Num;

    }
    public void addPoints(int Num)
    {

            NumLoyaltyPoints = NumLoyaltyPoints + Num;

    }
    public void spendCredits(int Num)
    {

            NumCredits = NumCredits - Num;

    }
    public void covertLoyaltyPoints()
    {
        NumCredits = NumCredits + (NumLoyaltyPoints / 4);
        NumLoyaltyPoints = NumLoyaltyPoints % 4;
    
    }
    public int accessRating()
    {
        
        return LuxuryRating;
    }
        public int accessCredits()
    {
        
        return NumCredits;
    }
            public int accessID()
    {
        
        return ID;
    }
        public boolean checkID(int Test)
    {
        if (Test == ID)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
            public boolean checkRide()
    {
        if ((NumCredits- 3) >= 0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
        public String toString()
    {
        String s = "****************" + "\n*  Card Details";
        s = s + "\n*  ID: " + ID  + "\n*  Name: " 
              + Name + "\n*  Luxury Rating : " +  LuxuryRating + "\n*  Credit Balance : " 
              +  NumCredits + "\n*  Loyalty Points Balance : " +  NumLoyaltyPoints; 
        s = s + "\n*****************";
        return s;
    }
}
