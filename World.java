import java.util.*;
/**
 * Write a description of class World here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class World
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> OnWorld = new ArrayList<Card>();
    private int ID;
    private String Name;
    private int Rating;
    private int Capacity;
    /**
     * Constructor for objects of class World
     */
    public World(int inNUM,String inName,int inRating, int inCapacity)
    {
        ID = inNUM;
        Name = inName;
        Rating = inRating;
        Capacity = inCapacity;
    }
        public int getID()
    {
        return ID;
    }
    public int checkRating()
    {
        return Rating;
    }
        public String getName()
    {
        return Name;
    }
    
    public boolean IsName(String MaybeName)
    {
        if (Name .equals( MaybeName)){
            return true;
        }
        else {
        return false;}
    }
    
        public void enter(Card entrant)
    {
        OnWorld.add(entrant);
    }
    
    public void leave(Card leaver)
    {
        OnWorld.remove(leaver);
    }
        public boolean checkAtCap()
    {
        if (OnWorld.size() >= Capacity)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
        public String getAllCards()
    {
        String AllCards = "";
        if (OnWorld.size() != 0){
        //AllCards = "\n* All Guest Cards on world "+ Name +": \n*";
        for(Card temp : OnWorld) // get each item in turn
        {   
            AllCards = AllCards + temp.toString() + "\n";
        }}
        else {AllCards ="\n* No Cards on World";}
        return AllCards;
        
    }
        public boolean findCardById(int id)
    {
        for(Card temp : OnWorld) // get each item in turn
        {   
            if (temp.checkID(id) == true)
            {
                return true; 
            }
        }
        return false;
    }
    public Card getCardById(int id)
    {
        for(Card temp : OnWorld) // get each item in turn
        {   
            if (temp.checkID(id) == true)
            {
                return temp; 
            }
        }
        return null;
    }
            public String toString()
    {
        String s = "****************" + "\n*  World Details";
        s = s + "\n*  Name: " + Name + "\n*  Rating : " +  Rating + "\n* Capacity : " 
              +  Capacity + "\n*  Current Guest Numbers : " +  OnWorld.size();
        s = s + "\n*****************";
        return s;
    }
}
