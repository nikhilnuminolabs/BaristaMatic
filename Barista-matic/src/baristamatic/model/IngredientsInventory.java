package baristamatic.model;

import static baristamatic.constant.InventoryConstant.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represent the Inventory of Ingredients
 *
 */
public class IngredientsInventory {

	private Map<String,Ingredient> Ingredients;

	private Map<Ingredient,Integer> ingredientsStock;

	public IngredientsInventory() {
		Ingredients = new TreeMap<String,Ingredient>();
		ingredientsStock = new TreeMap<Ingredient,Integer>();
		init();
	}

	private void init() {

		Ingredients.put(COFFEE, new Ingredient(COFFEE,0.75f));
		Ingredients.put(DECAF_COFFEE, new Ingredient(DECAF_COFFEE,0.75f));
		Ingredients.put(SUGAR, new Ingredient(SUGAR,0.25f));
		Ingredients.put(CREAM, new Ingredient(CREAM,0.25f));
		Ingredients.put(STEAMED_MILK, new Ingredient(STEAMED_MILK,0.35f));
		Ingredients.put(FOAMED_MILK, new Ingredient(FOAMED_MILK,0.35f));
		Ingredients.put(ESPRESSO, new Ingredient(ESPRESSO,1.10f));
		Ingredients.put(COCOA,  new Ingredient(COCOA,0.90f));
		Ingredients.put(WHIPPED_CREAM,  new Ingredient(WHIPPED_CREAM,1.00f));

		restockIngredientsInventory();

	}

	public void restockIngredientsInventory() {

		ingredientsStock.put(Ingredients.get(COFFEE), MAXSTOCK);		
		ingredientsStock.put(Ingredients.get(DECAF_COFFEE), MAXSTOCK);	
		ingredientsStock.put(Ingredients.get(SUGAR), MAXSTOCK);		
		ingredientsStock.put(Ingredients.get(CREAM), MAXSTOCK);	
		ingredientsStock.put(Ingredients.get(STEAMED_MILK), MAXSTOCK);		
		ingredientsStock.put(Ingredients.get(FOAMED_MILK), MAXSTOCK);	
		ingredientsStock.put(Ingredients.get(ESPRESSO), MAXSTOCK);	
		ingredientsStock.put(Ingredients.get(COCOA), MAXSTOCK);
		ingredientsStock.put(Ingredients.get(WHIPPED_CREAM), MAXSTOCK);

	}

	public Map<String, Ingredient> getIngredients() {
		return Ingredients;
	}

	public void updateIngredientsInventory(Map<Ingredient,Integer> drinkIngredients ) {

		for (Map.Entry<Ingredient,Integer> ingredient : drinkIngredients.entrySet()) {

			if(ingredientsStock.get(ingredient.getKey()) >= ingredient.getValue()) {
				ingredientsStock.put(ingredient.getKey(),(ingredientsStock.get(ingredient.getKey()) - ingredient.getValue()));
			}
		}
	}

	public Integer getIngredientStock(Ingredient Ingredient) {

		return ingredientsStock.get(Ingredient);
	}

	public void displayInventry() {

		for (Map.Entry<Ingredient, Integer> inventryIngredient : ingredientsStock.entrySet()) {
			System.out.println(inventryIngredient.getKey().getName()+","+inventryIngredient.getValue());
		}

	}

	public Boolean getDrinkIngredientsAvailability(Map<Ingredient,Integer> drinkIngredients) {

		for (Map.Entry<Ingredient,Integer> drinkIngredient : drinkIngredients.entrySet()) {				

			if(getIngredientStock (drinkIngredient.getKey()) < drinkIngredient.getValue() ) {
				return false;
			} 			
		}

		return true;
	}

	@Override
	public String toString() {
		return "Inventory [Ingredients=" + Ingredients + "]";
	}

}
