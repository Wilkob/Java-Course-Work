
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyTester 
{   private ResortManager wayward = new ResortManager("wayward"); 
    public void doTest1()
    { // write your  tests here
        System.out.println("\n* ##########TEST 1########## \n*");
        System.out.println(wayward.toString());//testing that resort details can be displayed 
        System.out.println("\n* ##########TEST 2########## \n*");
        System.out.println(wayward.getAllCardsOnEachWorld()); //testing that cards can be displayed by world 
        System.out.println("\n* ##########TEST 3########## \n*");
        System.out.println(wayward.getAllCardsOnWorld("Home")); // testing that can display cards on a world with cards
        System.out.println("\n* ##########TEST 4########## \n*");
        System.out.println(wayward.getAllCardsOnWorld("Solo")); // testing that can display cards on a world without any cards cards
        System.out.println("\n* ##########TEST 5########## \n*");
        System.out.println(wayward.findCard(1000));// testing finding a specific card
        System.out.println("\n* ##########TEST 6########## \n*");
        System.out.println(wayward.canTravel(1000,"JKL8 "));// testing what will happen if a cards checks to move from somewhere it is not 
        System.out.println("\n* ##########TEST 7########## \n*");
        System.out.println(wayward.canTravel(1000,"ABC1"));// testing what will happen if a cards checks to move from somewhere it is on a vaild shuttle
        System.out.println("\n* ##########TEST 8########## \n*");
        System.out.println(wayward.travel(1000,"JKL8 "));;// testing what will happen if a cards trys to move from somewhere it is not
        
        
        System.out.println("\n* ##########TEST 9########## \n*");
        System.out.println(wayward.travel(1000,"ABC1"));// testing what will happen if a cards trys to move from somewhere it is on a vaild shuttle

        
        // System.out.println("\n* ##########TEST 1########## \n*");
        // System.out.println("\n* ##########TEST 2########## \n*");
        // System.out.println("\n* ##########TEST 3########## \n*");
        // System.out.println("\n* ##########TEST 4########## \n*");
        // System.out.println("\n* ##########TEST 5########## \n*");
        // System.out.println("\n* ##########TEST 6########## \n*");
        // System.out.println("\n* ##########TEST 7########## \n*");
        // System.out.println("\n* ##########TEST 8########## \n*");
        // System.out.println("\n* ##########TEST 9########## \n*");
        // System.out.println("\n* ##########TEST 1########## \n*");
        // System.out.println("\n* ##########TEST 2########## \n*");
        // System.out.println("\n* ##########TEST 3########## \n*");
        // System.out.println("\n* ##########TEST 4########## \n*");
        // System.out.println("\n* ##########TEST 5########## \n*");
        // System.out.println("\n* ##########TEST 6########## \n*");
        // System.out.println("\n* ##########TEST 7########## \n*");
        // System.out.println("\n* ##########TEST 8########## \n*");
        // System.out.println("\n* ##########TEST 9########## \n*");
    }
     
    
}
