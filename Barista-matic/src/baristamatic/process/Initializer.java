package baristamatic.process;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static baristamatic.constant.InventoryConstant.*;
import baristamatic.model.Drink;
import baristamatic.model.Ingredient;

/**
 * Class to initialize the Process.class object  
 *
 */
public class Initializer {
	
	/**
	 * Initialize the Process.class object with predefine values
	 * @param process 
	 */
	public void initializeObject(Process process) {

		Map<String,Drink> drinkList = process.getDrinkList();

		Map<String,Ingredient> inventryIngredients = process.getInventory().getIngredients();

		List<String> drinkNameList = process.getDrinkNameList();

		// Initializing  the Drink object
		
		Map<Ingredient,Integer> CoffeeIngredients = new TreeMap<Ingredient,Integer>();
		CoffeeIngredients.put(inventryIngredients.get(COFFEE),3);
		CoffeeIngredients.put(inventryIngredients.get(SUGAR),1);
		CoffeeIngredients.put(inventryIngredients.get(CREAM),1);

		drinkList.put(COFFEE_DRINK, new Drink(COFFEE_DRINK,CoffeeIngredients,true));

		Map<Ingredient,Integer> DecafCoffeeIngredients = new TreeMap<Ingredient,Integer>();
		DecafCoffeeIngredients.put(inventryIngredients.get(DECAF_COFFEE),3);
		DecafCoffeeIngredients.put(inventryIngredients.get(SUGAR),1);
		DecafCoffeeIngredients.put(inventryIngredients.get(CREAM),1);
		drinkList.put(DECAF_COFFEE_DRINK,new Drink(DECAF_COFFEE_DRINK,DecafCoffeeIngredients,true));

		Map<Ingredient,Integer> CaffeLatteIngredients = new TreeMap<Ingredient,Integer>();
		CaffeLatteIngredients.put(inventryIngredients.get(ESPRESSO),2);
		CaffeLatteIngredients.put(inventryIngredients.get(STEAMED_MILK),1);
		drinkList.put(CAFFE_LATTE_DRINK,new Drink(CAFFE_LATTE_DRINK,CaffeLatteIngredients,true));

		Map<Ingredient,Integer> CaffeAmericanoIngredients = new TreeMap<Ingredient,Integer>();
		CaffeAmericanoIngredients.put(inventryIngredients.get(ESPRESSO),3);
		drinkList.put(CAFFE_AMERICANO_DRINK,new Drink(CAFFE_AMERICANO_DRINK,CaffeAmericanoIngredients,true));

		Map<Ingredient,Integer> CaffeMochaIngredients = new TreeMap<Ingredient,Integer>();
		CaffeMochaIngredients.put(inventryIngredients.get(ESPRESSO),1);
		CaffeMochaIngredients.put(inventryIngredients.get(COCOA),1);
		CaffeMochaIngredients.put(inventryIngredients.get(STEAMED_MILK),1);
		CaffeMochaIngredients.put(inventryIngredients.get(WHIPPED_CREAM),1);
		drinkList.put(CAFFEMOCHA_DRINK,new Drink(CAFFEMOCHA_DRINK,CaffeMochaIngredients,true));

		Map<Ingredient,Integer> CappuccinoIngredients = new TreeMap<Ingredient,Integer>();
		CappuccinoIngredients.put(inventryIngredients.get(ESPRESSO),2);
		CappuccinoIngredients.put(inventryIngredients.get(STEAMED_MILK),1);
		CappuccinoIngredients.put(inventryIngredients.get(FOAMED_MILK),1);
		drinkList.put(CAPPUCCINO_DRINK,new Drink(CAPPUCCINO_DRINK,CappuccinoIngredients,true));
		

		for (Map.Entry<String,Drink> drink : drinkList.entrySet()) {
			drinkNameList.add(drink.getKey());
		} 
	}
		
}
