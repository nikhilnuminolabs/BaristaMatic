package baristamatic.model;

import static baristamatic.constant.InventoryConstant.*;

import java.util.HashMap;

import java.util.Map;
import java.util.TreeMap;

public class Drinks {

	private Map<String,Drink> drinkList;

	private Map<Integer,String> drinkNameList;

	public Drinks(Map<String, Ingredient> ingredientsInventory) {

		this.drinkList = new TreeMap<String,Drink>();

		this.drinkNameList = new HashMap<Integer,String>();

		init(ingredientsInventory);
	}

	private void init(Map<String, Ingredient> ingredientsInventory) {

		initializeDrink(ingredientsInventory);

		initializeDrinkNameList();

	}

	private void initializeDrink(Map<String, Ingredient> ingredientsInventory) {

		Map<Ingredient,Integer> CoffeeIngredients = new TreeMap<Ingredient,Integer>();
		CoffeeIngredients.put(ingredientsInventory.get(COFFEE),3);
		CoffeeIngredients.put(ingredientsInventory.get(SUGAR),1);
		CoffeeIngredients.put(ingredientsInventory.get(CREAM),1);

		drinkList.put(COFFEE_DRINK, new Drink(COFFEE_DRINK,CoffeeIngredients));

		Map<Ingredient,Integer> DecafCoffeeIngredients = new TreeMap<Ingredient,Integer>();
		DecafCoffeeIngredients.put(ingredientsInventory.get(DECAF_COFFEE),3);
		DecafCoffeeIngredients.put(ingredientsInventory.get(SUGAR),1);
		DecafCoffeeIngredients.put(ingredientsInventory.get(CREAM),1);
		drinkList.put(DECAF_COFFEE_DRINK,new Drink(DECAF_COFFEE_DRINK,DecafCoffeeIngredients));

		Map<Ingredient,Integer> CaffeLatteIngredients = new TreeMap<Ingredient,Integer>();
		CaffeLatteIngredients.put(ingredientsInventory.get(ESPRESSO),2);
		CaffeLatteIngredients.put(ingredientsInventory.get(STEAMED_MILK),1);
		drinkList.put(CAFFE_LATTE_DRINK,new Drink(CAFFE_LATTE_DRINK,CaffeLatteIngredients));

		Map<Ingredient,Integer> CaffeAmericanoIngredients = new TreeMap<Ingredient,Integer>();
		CaffeAmericanoIngredients.put(ingredientsInventory.get(ESPRESSO),3);
		drinkList.put(CAFFE_AMERICANO_DRINK,new Drink(CAFFE_AMERICANO_DRINK,CaffeAmericanoIngredients));

		Map<Ingredient,Integer> CaffeMochaIngredients = new TreeMap<Ingredient,Integer>();
		CaffeMochaIngredients.put(ingredientsInventory.get(ESPRESSO),1);
		CaffeMochaIngredients.put(ingredientsInventory.get(COCOA),1);
		CaffeMochaIngredients.put(ingredientsInventory.get(STEAMED_MILK),1);
		CaffeMochaIngredients.put(ingredientsInventory.get(WHIPPED_CREAM),1);
		drinkList.put(CAFFEMOCHA_DRINK,new Drink(CAFFEMOCHA_DRINK,CaffeMochaIngredients));

		Map<Ingredient,Integer> CappuccinoIngredients = new TreeMap<Ingredient,Integer>();
		CappuccinoIngredients.put(ingredientsInventory.get(ESPRESSO),2);
		CappuccinoIngredients.put(ingredientsInventory.get(STEAMED_MILK),1);
		CappuccinoIngredients.put(ingredientsInventory.get(FOAMED_MILK),1);
		drinkList.put(CAPPUCCINO_DRINK,new Drink(CAPPUCCINO_DRINK,CappuccinoIngredients));

	}

	private void initializeDrinkNameList() {

		Integer drinkIndex = 0;		
		for (Map.Entry<String,Drink> drink : drinkList.entrySet()) {
			drinkIndex++;
			drinkNameList.put(drinkIndex,drink.getKey());
		} 

	}
	
	public Map<Integer,String> getAllDrinkNameList() {

		return drinkNameList ;
	}

	public Drink getDrinkById(Integer drinkId) {

		return drinkList.get(drinkNameList.get(drinkId)) ;
	}
	
	public Boolean isVaidDrinkId(Integer drinkId) {

		return drinkList.containsKey(drinkNameList.get(drinkId)) ;
	}
		

}
