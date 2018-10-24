package control;

import java.io.Serializable;
import java.util.Random;
import model.CropData;

/**
 *The CropControlclass -part of the control layer
 * class contains all of the calculation methods for managing the crops
 * Author: Collin, Jacob & Daniel 
 **/
public class CropControl implements Serializable{

    //Constants
    private static int LAND_BASE = 17;
    private static int LAND_RANGE = 10;
    
    //random number Generator
    private static Random random = new Random();
    
    /**
    * sellLandmethod
    * Purpose: Sell land -subtracts from the acres owned
    * Parameters: landPrice, the number of acres to sell, and a
    * reference to a CropDataobject
    * Pre-conditions: acresToSell>= 0 and acresToSell<= acresOwned
    * Returns: the number of acres owned after the sale
    */
    public static int sellLand(int landPrice, int acresToSell, CropData cropData)
    {
            //if acresToSell< 0, return -1
        if (acresToSell< 0)
        {
            return -1;
        }

        //if acresToSell> acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();

        if (acresToSell > cropData.getAcresOwned())
        {
            return -1;
        }

        //acresOwned= acresOwned-acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);

        //wheatInStore= wheatInStore+ (acresToBuyx landPrice)
        int wheatInStore= cropData.getWheatInStore();
        wheatInStore += (acresToSell* landPrice);
        cropData.setWheatInStore(wheatInStore);

        //return acresOwned
        return acresOwned;
    }
    
    /**
    *The buyLand Method
    *Purpose: To Buy Land
    *@param the price of land
    *@param the number of acres to buy
    *@param a reference to CropData
    *PreConditions: acresToBuy must be positive
    * and landPrice is between 17-27
    * Author Collin, Jacob, Daniel
    */
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData)
    {
        //If acresToBuy < 0, return -1
        if (acresToBuy < 0)
        {
            return -1;
        }
                
        //If landPrice < 17 or landPrice > 27, return -1
        if (landPrice < 17 || landPrice > 27)
        {
            return -1;
        }
        
        //If (acresOwned + acresToBuy) / 10 > population, return -1
        if (((cropData.getAcresOwned() + acresToBuy) / 10) 
            > cropData.getPopulation())
        {
            return -1;
        }
        
        //If wheatInStore < (acresToBuy * landPrice), return -1
        if (cropData.getWheatInStore() < (acresToBuy * landPrice))
        {
            return -1;
        }
        
        //acresOwned = acresOwned + acresToBuy
        cropData.setAcresOwned(cropData.getAcresOwned() + acresToBuy);
        
        //wheatInStore = wheatInStore – (landPrice * acresToBuy)
        cropData.setWheatInStore(cropData.getWheatInStore() 
                - (landPrice * acresToBuy));
        
        //return acresOwned
        return cropData.getAcresOwned();
    }
    
    
    public static int calcLandCost()
    {
        int landPrice= random.nextInt(LAND_RANGE) + LAND_BASE;
        return landPrice;
    }
           
    /**
    *The setOffering Method
    *Purpose: To set the Offering %
    *@param integer to be converted to % for offering
    *@param a reference to CropData
    *Pre-Conditions: offeringPrecentage is in the range of 0 to 100
    */
    public static int setOffering(int offeringPrecentage, CropData cropData)
    {
        //If offeringPrecentage < 0 OR offeringPrecentage > 100 , return -1
        if (offeringPrecentage < 0 || offeringPrecentage > 100)
        {
            return -1;
        }
        
        //offering = offeringPrecentage
        cropData.setOffering(offeringPrecentage);
        
        //return offering
        return cropData.getOffering();
    }
   
    
    
}