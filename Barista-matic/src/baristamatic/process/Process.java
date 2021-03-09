package baristamatic.process;
import java.util.Map;
import baristamatic.model.Drink;
import baristamatic.model.Drinks;
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

				if(ingredientsInventory.getDrinkIngredientsAvailability(drinkObj.getIngredients())) { 

					ingredientsInventory.updateIngredientsInventory(drinkObj.getIngredients());

					System.out.println(DISPENSING+drinkObj.getName());   

				}else {
					System.out.println(OUT_OF_STOCK+drinkObj.getName());
				}
			} else {
				invalidInputMessage(input);
			}

		}
		catch(NumberFormatException ex) {
			invalidInputMessage(input);
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
		displayDrinkList();

	}

	/**
	 * display error message for invalid data
	 * @param input input from system
	 */
	public void invalidInputMessage(String input) {

		System.out.println(INVALID_SELECTION+input);
	}
	
	public void displayDrinkList() {

		for (Map.Entry<Integer,String> drinkName : drinks.getAllDrinkNameList().entrySet()) {
			Drink drinkObject = drinks.getDrinkById(drinkName.getKey());
			System.out.println(drinkName.getKey()+","+drinkObject.getName()+","+PRICE_UNIT+drinkObject.getCost()+","+ingredientsInventory.getDrinkIngredientsAvailability(drinkObject.getIngredients()));
		}	
	}

}
