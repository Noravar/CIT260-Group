package view;

import java.util.Scanner;
import cityofaaron.CityOfAaron;
import control.*;
import model.*;

/**
 * The MainMenuView Class - Part of the view Layer
 * @Class CIT260
 * @Brother Wright
 * @author Jacob Gallegos
 * Date Last Modified 10/30/2018
 */

public class ListMenuView extends MenuView 
{
    //Variables
    Scanner keyboard = new Scanner(System.in);
    private int max;
    private String listMenu;
    private Game theGame = CityOfAaron.getTheGame();
    
    
    /**
    * The ListMenuconstructor
    * Purpose: Initialize the list data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public ListMenuView()
    {
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: MAIN GAME MENU *\n" +
            "**********************************\n" +
            " 1 -View animals in the storehouse\n" +
            " 2 -View the tools in the storehouse\n" +
            " 3 -View the provisions in the storehouse\n" +
            " 4 -View the authors of this game\n" +
            " 5 -Quit\n",
             5);
    }  

    /**
    *The doActionmethod
    * Purpose: performs the selected action    
    * Returns: none
     * @param option
    */
    @Override public void doAction(int option)
    {
      int options = option;
      if(options == 1){
          listAnimals();          
      }
      else if(options == 2){
          listTools();
      }
      else if(options == 3){
          listProvisions();
      }
      else if(options == 4){
          listTeam();
      }
      else if(options == 5){
          System.out.println("Returning to game menu view.");
      }
      
      
    }
    
    
    /**
    * The listAnimals method
    * Purpose: List the number of Animals in the storehouse
    * Parameters: none
    * Returns: none
    * Last Modified:11/06/2018
    */
    // ===================================
    public void listAnimals()
    {
      // List the number of Animals in the storehouse
        System.out.println("View Animals Selected");
        for(ListItem item : theGame.getAnimals())
        {           
             String line = String.format("%1$-20s %2$d", item.getName(), item.getNumber());
            System.out.println(line);
        }
        
    }
    
    /**
    * The listTools method
    * Purpose: List the number of Tools in the storehouse
    * Parameters: none
    * Returns: none
    * Author: Collin Blake
    */
    // ===================================
    public void listTools()
    {
        System.out.println("Tools in the City of Aaron:");
        for(ListItem item : theGame.getTools())
        {           
             String line = String.format("%1$-20s %2$d", item.getName(), item.getNumber());
            System.out.println(line);
        }
    } 
    
        /**
    * The listTools method
    * Purpose: Displays a list of the Provisions
    * Parameters: none
    * Returns: none
    * Author: Jacob Gallegos
    */
    // ===================================
    public void listProvisions()
    {
        //List the number of provisions in the storehouse
        //This is my code for printing it out. It does not work I am trying
        //To figure it out.
        
//        for(int i = 0; i < theGame.getProvisions().size(); i++){
//            for(int j = 0; j < theGame.getProvisions().get(i).size(); j++)
//            {
//                System.out.println(theGame.getProvisions().get(i).get(j));
//            
//            }
//            
//            }
        
    }
    
        /**
    * The listTeam method
    * Purpose: List the number of Teams
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void listTeam()
    {
        //List the number of Teams
        System.out.println("View Teams selected");
    }
}

