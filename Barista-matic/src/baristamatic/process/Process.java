package baristamatic.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import baristamatic.model.Drink;
import baristamatic.model.Ingredient;
import baristamatic.model.Inventory; 
import static baristamatic.constant.InventoryConstant.*;

/**
 * Contains functions to do data manipulation operation on  
 * all drinks and Ingredients Inventory
 */
public class Process {

	private Map<String,Drink> drinkList;

	private Inventory inventory;

	private List<String> drinkNameList;

	public Process() {
		drinkList = new TreeMap<String,Drink>();
		drinkNameList = new ArrayList<String>();
		inventory = new Inventory();
	}

	public Map<String, Drink> getDrinkList() {
		return drinkList;
	}

	public void setDrinkList(Map<String, Drink> drinkList) {
		this.drinkList = drinkList;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<String> getDrinkNameList() {
		return drinkNameList;
	}

	public void setDrinkNameList(List<String> drinkNameList) {
		this.drinkNameList = drinkNameList;
	}

	/**
	 * Dispensed the Drink with updating the Ingredients Inventory and Drink availability status
	 * @param drinkNumber Id of Drink 
	 */
	public void drinkDispens(String input) {

		try {
			
			Integer drinkId = Integer.parseInt(input);
			List<String> drinksNameList = this.drinkNameList ;
			Map<String,Drink> drinksList = this.drinkList;
			if(drinkId > 0 && drinkId <= drinksList.size()) {

				String drinkName = drinksNameList.get(drinkId-1);
				Boolean drinkAvailabilityStatus = drinksList.get(drinkName).isAvailabilityStatus();

				if(drinkAvailabilityStatus) { 

					updateInventry(drinkName);

					updateDrinkAvailability();

					System.out.println("Dispensing: "+drinkName);   
					
				}else {
					System.out.println("Out of stock: "+drinkName);
				}
			} else {
				invalidDataMessage(input);
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Update the inventory after drink dispensed
	 * @param drinkName name of Drink
	 */
	public void updateInventry(String drinkName) {

		Drink drink = this.getDrinkList().get(drinkName);

		Map<Ingredient,Integer> ingredientsInventory = this.inventory.getIngredientsAvaibality();

		Map<Ingredient,Integer> drinkIngredients = drink.getIngredients();

		for (Map.Entry<Ingredient,Integer> ingredient : drinkIngredients.entrySet()) {

			if(ingredientsInventory.containsKey(ingredient.getKey())){
				int drinkIngredientCount = ingredient.getValue();
				int ingredientInventryCount =  ingredientsInventory.get(ingredient.getKey());
				if(ingredientInventryCount >= drinkIngredientCount) {
					ingredientsInventory.put(ingredient.getKey(),(ingredientInventryCount - drinkIngredientCount));
				}
			}
		} 
	}


	/**
	 * Update the availability status of all drinks after drink dispensed
	 */
	public void updateDrinkAvailability() {

		Map<Ingredient, Integer> ingredientsAvailability = this.inventory.getIngredientsAvaibality();
		Map<String,Drink> drinksList = this.drinkList;

		for (Map.Entry<String,Drink> drink : drinksList.entrySet()) {
			Drink drinkObj = drink.getValue();
			Map<Ingredient,Integer> drinkIngredients = drinkObj.getIngredients();

			for (Map.Entry<Ingredient,Integer> drinkIngredient : drinkIngredients.entrySet()) {				
				int drinkIngridientCount = drinkIngredient.getValue();
				int ingridientInventryCount =  ingredientsAvailability.get(drinkIngredient.getKey());
				if(ingridientInventryCount < drinkIngridientCount ) {
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

		Map<Ingredient,Integer> ingredientsInventory = this.inventory.getIngredientsAvaibality();

		for (Map.Entry<Ingredient,Integer> inventryIngredient : ingredientsInventory.entrySet()) {
			inventryIngredient.setValue(MAXSTOCK);
		}
		
		updateDrinkAvailability();
	}

	/**
	 * Display all drinks and Ingredients inventory data
	 */
	public void displayOutput() {

		System.out.println("Inventory:");
		displayInventry();

		System.out.println("Menu:");
		displayDrinkList();

	}

	/**
	 * Display Ingredients inventory data
	 */
	public void displayInventry() {

		Map<Ingredient, Integer> ingredientsInventory = this.inventory.getIngredientsAvaibality();
		
		for (Map.Entry<Ingredient, Integer> inventryIngredient : ingredientsInventory.entrySet()) {
			System.out.println(inventryIngredient.getKey().getName()+","+inventryIngredient.getValue());
		}

	}

	/**
	 * Display all drinks data
	 */
	public void displayDrinkList() {

		Map<String,Drink> drinksList = this.drinkList;

		for(int i=0;i<drinksList.size();i++) {			
			Drink drinkObject = drinksList.get(drinkNameList.get(i));
			System.out.println((i+1)+","+drinkObject.getName()+",$"+drinkObject.getCost()+","+drinkObject.isAvailabilityStatus());		
		} 

	}

	/**
	 * display error message for invalid data
	 * @param input input from system
	 */
	public void invalidDataMessage(String input) {

		System.out.println("Invalid selection: "+input);
	}

}
