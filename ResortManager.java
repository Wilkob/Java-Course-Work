
import java.util.*;

/**This class implements Cwk 2
 *
 * @author A.A.Marczyk 
 * @version 09/02/20
 **/
public class ResortManager 
{
   //ResortManager Fields 
  
    private String locationName;
    private ArrayList<World> allWorlds = new ArrayList<World>();
    private ArrayList<Card> allCards = new ArrayList<Card>(); 
    private ArrayList<Shuttle> allShuttles = new ArrayList<Shuttle>();
    
    /**
     * Returns all of the data about all worlds including the cards
     * currently on each world, r "No cards"
     * @return all of the details of all worlds including  
     * and all cards currently on each world, or "No cards" 
     */
    public String toString()
    {
        String s = "##################";
         for(World temp : allWorlds) // get each item in turn
        {   
            s = s + temp.toString();
            s = s + getAllCardsOnWorld(temp.getName()) + "\n";
        }
        // for(Shuttle temp : allShuttles) // get each item in turn
        // {   
            // s = s + temp.toString();
        // }
        s = s + "##################";
        return s;
    }
    public ResortManager(String inName)
    {

        locationName = inName;
        loadWorlds();
        loadCards();
        setUpShuttles();
        
    }
    /**Returns a String representation of all the cards on all worlds, listed 
     * by world 
     * @return a String representation of all cards on all worlds
     **/
    public String getAllCardsOnEachWorld()
    {
        String s = "##################";
         for(World temp : allWorlds) // get each item in turn
        {   s = s + temp.getName();
            s = s + getAllCardsOnWorld(temp.getName()) + "\n";
        }
        s = s + "##################";
        return s;
    }
    
    
    /**Returns the name of the world which contains the specified card or null
     * @param cr - the specified card
     * @return the name of the World which contains the card, or null
     **/
    public String findCard(int cr)
    {
        for(World temp : allWorlds) // get each item in turn
        {   
            if (temp.findCardById(cr) == true){
            return temp.getName();
            }
        }
        return null;
    }
    
    
    /** Given the name of a world, returns the world id number
     * or -1 if world does not exist
     * @param name of world
     * @return id number of world
     */
    public int getWorldNumber(String ww)
    {
        for(World temp : allWorlds) // get each item in turn
        {   
            if (temp.IsName(ww.replaceAll("\\P{Print}","")) == true){
            return temp.getID();
            }
        }
        return -1;
    }
    
                
    /**Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     **/
    public String getAllCardsOnWorld(String world)
    {
        String s = "";
         for(World temp : allWorlds) // get each item in turn
        {   
            if (temp.IsName(world.replaceAll("\\P{Print}",""))){        
                s = "****************" + "\n*  Cards on World:";
        s = s + "\n*  Name: " + world + temp.getAllCards();
        s = s + "\n*****************";
        }
        }
        return s;
    }

     /**Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param crId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return true if the card is allowed on the shuttle journey, false otherwise 
     **/
    public boolean canTravel(int crId, String shtlCode)
    {
        Card c = null;
        String s = "";
        boolean result = false;
        c = getCard(crId);
        for(Shuttle temp : allShuttles) // get each item in turn
        {   
            if  (temp.checkJourneyCode(shtlCode.replaceAll("\\P{Print}","")) == true){
                
                result = temp.checkTravel(c) ;
            }
            
            }
           return result;
        }
    
    

    /**Returns the result of a card requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the card information is removed from the source
     * world, added to the destination world and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return a String giving the result of the request 
     **/
    public String travel(int pCardId, String shtlCode )
    {
        Card c = getCard(pCardId);
        Shuttle s = getShuttle(shtlCode);
        return s.AttemptTravel(c);
        
    }
        

    

     
    // These methods are for Task 6 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following code    
    // /** Allows a card to top up their credits.This method is not concerned with 
     // *  the cost of a credit as currency and prices may vary between resorts.
     // *  @param id the id of the card toping up their credits
     // *  @param creds the number of credits purchased to be added to cards information
     // */
    public void topUpCredits(int id, int creds)
    {
        Card c = getCard(id);
        c.addCredits(creds);
    }
    
    // /** Moves a card directly back to the home world without affecting credits
     // *  and not using existing shuttles
     // */
    public void moveHome(int id)
    {
        Card c = getCard(id);
        World w = getWorld(findCard(id));
        World h = getWorld("Home");
        w.leave(c);
        h.enter(c);
        
    }
  
    // /** Converts a business card's loyalty points into credits
     // * @param tr the id of the card whose points are to be converted
     // */
    public void convertPoints(int id)
    {
        Card c = getCard(id);
        c.covertLoyaltyPoints();
    }
    
    // /** In an emergency, evacuates all cards directly back to the home world without 
     // * affecting credits or other information and not using existing shuttles
     // */
    public void evacuateAll()
    {
        for(Card temp : allCards) // get each item in turn
        {   
            int x = temp.accessID();
            moveHome(x);
            }
    }
    
   
    
    
    //***************private methods**************
    // create all cards in Appendix A and addthem to their collection
    private void loadCards()
    {        
      World home = getWorld("Home");
      allCards.add(new Card(1000,"Lynn",5,10));
      allCards.add(new Card(1001,"May",3,30));
      allCards.add(new Card(1002,"Nils",10,25));
      allCards.add(new Card(1003,"Olek",2,12));
      allCards.add(new Card(1004,"Pan",3,3));
      allCards.add(new Card(1005,"Quin",1,30));
      allCards.add(new Card(1006,"Raj",10,6));
      allCards.add(new Card(1007,"Sol",7,20));
      allCards.add(new Card(1008,"Tel",6,30));
      for(Card temp : allCards) // get each item in turn
        {   
        home.enter(temp);
       }
    }
    
    
    // create all worlds in Appendix A and addthem to their collection
    private void loadWorlds()
    {
        allWorlds.add(new World(0,"Home",0,1000));
        allWorlds.add(new World(1,"Sprite",1,100));
        allWorlds.add(new World(2,"Tropicana",3,10));
        allWorlds.add(new World(3,"Fantasia",5,2));
        allWorlds.add(new World(4,"Solo",1,1));
    }
    
    // create all shuttles in Appendix A and addthem to their collection
    private void setUpShuttles()
    {
        allShuttles.add(new Shuttle("ABC1",getWorld("Home"),getWorld("Sprite")));    
        allShuttles.add(new Shuttle("BCD2 ",getWorld("Sprite"),getWorld("Home")));
        allShuttles.add(new Shuttle("CDE3 ",getWorld("Sprite"),getWorld("Tropicana")));
        allShuttles.add(new Shuttle("DEF4 ",getWorld("Tropicana"),getWorld("Sprite")));
        allShuttles.add(new Shuttle("JKL8 ",getWorld("Tropicana"),getWorld("Fantasia")));
        allShuttles.add(new Shuttle("EFG5 ",getWorld("Fantasia"),getWorld("Sprite")));
        allShuttles.add(new Shuttle("GHJ6 ",getWorld("Sprite"),getWorld("Solo")));
        allShuttles.add(new Shuttle("HJK7 ",getWorld("Solo"),getWorld("Sprite")));
    }
    
    
//  // Uncomment if you want to use.
//     /** Returns the card with the card id specified by the parameter
//      * @return the card with the specified name
//      **/
    private Card getCard(int ID){
        for(World temp : allWorlds) // get each item in turn
        {   
            if (temp.findCardById(ID) == true){
             Card c = temp.getCardById(ID);
             return(c);
            }
        }
        return (null);
    }

//     
//     /** Returns the world with the name specified by the parameter
//      * @return the world with the specified name
//      **/
    private World getWorld(String worldName)
    {
        for(World temp : allWorlds) // get each item in turn
        {   
            if (temp.IsName(worldName.replaceAll("\\P{Print}","")) == true){
            return temp;
            }
        }
        return null;
    }
//     
//     /** Returns the world with the name specified by the parameter
//      * @return the world with the specified name
//      **/
    private Shuttle getShuttle(String Code){
    for(Shuttle temp : allShuttles) // get each item in turn
        {   
            if  (temp.checkJourneyCode(Code.replaceAll("\\P{Print}","")) == true){
                return temp;
            }
        }return (null);
        }
}