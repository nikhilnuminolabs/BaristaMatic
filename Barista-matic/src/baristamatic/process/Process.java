package baristamatic.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import baristamatic.model.Drink;
import baristamatic.model.Drinks;
import baristamatic.model.Ingredient;
import baristamatic.model.IngredientsInventory; 
import static baristamatic.constant.InventoryConstant.*;

/**
 * Contains functions to do data manipulation operation on  
 * all drinks and Ingredients Inventory
 */
public class Process {

	private Drinks drinks;

	private IngredientsInventory ingredientsInventory;

	public Process() {		
		ingredientsInventory = new IngredientsInventory();
		drinks = new Drinks(ingredientsInventory.getIngredients());
	}
	/**
	 * Dispensed the Drink with updating the Ingredients Inventory and Drink availability status
	 * @param drinkNumber Id of Drink 
	 */
	public void drinkDispens(String input) {

		try {			
			Integer drinkId = Integer.parseInt(input);
	

		if(drinks.isVaidDrinkId(drinkId)) {
			
			Drink drinkObj = drinks.getDrinkById(drinkId);

			if(drinkObj.isAvailabilityStatus()) { 

				ingredientsInventory.updateIngredientsInventory(drinkObj.getIngredients());

				updateDrinkAvailability();

				System.out.println(DISPENSING+drinkObj.getName());   

			}else {
				System.out.println(OUT_OF_STOCK+drinkObj.getName());
			}
		} else {
			invalidDataMessage(input);
		}
		
		}
		catch(NumberFormatException ex) {
			invalidDataMessage(input);
		}
	}

	/**
	 * Update the availability status of all drinks after drink dispensed
	 */
	public void updateDrinkAvailability() {

		for (Map.Entry<Integer,String> drink : drinks.getAllDrinkNameList().entrySet()) {

			Drink drinkObj = drinks.getDrinkById(drink.getKey());
			for (Map.Entry<Ingredient,Integer> drinkIngredient : drinkObj.getIngredients().entrySet()) {				

				if(ingredientsInventory.getIngredientStock (drinkIngredient.getKey()) < drinkIngredient.getValue() ) {
					drinkObj.setAvailabilityStatus(false);
				} else	{
					drinkObj.setAvailabilityStatus(true);
				}			
			}
		} 
	}

	/**
	 * Restore the Ingredients inventory with max value
	 */
	public void restockInventry() {

		ingredientsInventory.restockIngredientsInventory();
	}

	/**
	 * Display all drinks and Ingredients inventory data
	 */
	public void displayOutput() {

		System.out.println("Inventory:");
		ingredientsInventory.displayInventry();

		System.out.println("Menu:");
		drinks.displayDrinkList();

	}

	/**
	 * display error message for invalid data
	 * @param input input from system
	 */
	public void invalidDataMessage(String input) {

		System.out.println(INVALID_SELECTION+input);
	}

}
