package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 * The CropView Class - Part of the View Layer
 * @Class CIT260
 * @Brother Wright
 * @author Collin Blake
 * Date Last Modified: 11/06/2018
 */
public class CropView {

    //Variables
    private static Scanner keyboard = new Scanner(System.in);
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData= theGame.getCropData();
    
    /**
    * The runCropsView method()
    * Purpose: runs the crop view methods
    * Parameters: none
    * Returns: none
    */
    public static void runCropsView()
    {
        // call the buyLandView( ) method
        buyLandView();
        
        // Other Calls
        feedPeopleView();

    }
       
    /**
    * The buyLandViewmethod
    * Purpose: interface with the user input for buying land
    * Parameters: none
    * Returns: none
    */
    public static void feedPeopleView()
    {
        //Ask User
        System.out.println("How many bushels of grain do you want to give to the people?");
        
        //Get value and save it
        int toGive;
        toGive = keyboard.nextInt();
        
        //Call feed people
        CropControl.feedThePeople(toGive, cropData);
        
        //output amonunt of wehat left.
         System.out.format("You now own %d bushels of wheat. \n", cropData.getWheatInStore());
    }
    
    /**
    * The buyLandViewmethod
    * Purpose: interface with the user input for buying land
    * Parameters: none
    * Returns: none
    */
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        
        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("How many acres of land do you wish to buy? ");
        
        // Get the user’s input and save it.
        int toBuy;
        toBuy = keyboard.nextInt();
        
        // Call the buyLand( ) method in the control layer to buy the land
        CropControl.buyLand(price,toBuy, cropData);
        
        // output how much land we now own
        System.out.format("You now own %d acres of land. \n", cropData.getAcresOwned());
    }
    
    /**
    * Purpose: Display the corps report view
    * Parameters: none
    * Returns: none 
     */
}
