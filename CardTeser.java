
/**
 * Write a description of class CardTeser here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CardTeser 
{
        public static void main(String[] args){
        Card card1 = new Card(1,"Billy",9,50);
        Card card2 = new Card(2,"Kathi",10,60);
        Card card3 = new Card(3,"Davey",1,8);
        System.out.println(card1.toString());
        card1.accessRating();
        card1.addCredits(2);
        System.out.println(card1.accessCredits());
        System.out.println(card1.checkRide());
        card1.spendCredits(52);
        System.out.println(card1.accessCredits());
        System.out.println(card1.checkRide());
        card1.addPoints(20);
        System.out.println(card1.toString());
        card1.covertLoyaltyPoints();
        System.out.println(card1.toString());
        System.out.println(card1.checkID(2));
        
        System.out.println(card2.toString());
        card2.accessRating();
        card2.addCredits(2);
        System.out.println(card2.accessCredits());
        System.out.println(card2.checkRide());
        card2.spendCredits(55);
        System.out.println(card2.accessCredits());
        System.out.println(card2.checkRide());
        card2.addPoints(20);
        System.out.println(card2.toString());
        card2.covertLoyaltyPoints();
        System.out.println(card2.toString());
        System.out.println(card2.checkID(2));
        
        System.out.println(card3.toString());
        card3.accessRating();
        card3.addCredits(2);
        System.out.println(card3.accessCredits());
        System.out.println(card3.checkRide());
        card3.spendCredits(10);
        System.out.println(card3.accessCredits());
        System.out.println(card3.checkRide());
        card3.addPoints(20);
        System.out.println(card3.toString());
        card3.covertLoyaltyPoints();
        System.out.println(card3.toString());
        System.out.println(card3.checkID(2));
        }
}
