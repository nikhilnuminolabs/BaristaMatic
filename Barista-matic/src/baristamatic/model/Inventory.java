package baristamatic.model;

import static baristamatic.constant.InventoryConstant.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represent the Inventory of Ingredients
 *
 */
public class Inventory {

	private Map<String,Ingredient> Ingredients;
	
	private Map<Ingredient,Integer> ingredientsAvaibality;

	public Inventory() {
		Ingredients = new TreeMap<String,Ingredient>();
		ingredientsAvaibality = new TreeMap<Ingredient,Integer>();
		init();
	}

	public Map<String, Ingredient> getIngredients() {
		return Ingredients;
	}
	
	public void init() {
		
		Ingredients.put(COFFEE, new Ingredient(COFFEE,0.75f));
		Ingredients.put(DECAF_COFFEE, new Ingredient(DECAF_COFFEE,0.75f));
		Ingredients.put(SUGAR, new Ingredient(SUGAR,0.25f));
		Ingredients.put(CREAM, new Ingredient(CREAM,0.25f));
		Ingredients.put(STEAMED_MILK, new Ingredient(STEAMED_MILK,0.35f));
		Ingredients.put(FOAMED_MILK, new Ingredient(FOAMED_MILK,0.35f));
		Ingredients.put(ESPRESSO, new Ingredient(ESPRESSO,1.10f));
		Ingredients.put(COCOA,  new Ingredient(COCOA,0.90f));
		Ingredients.put(WHIPPED_CREAM,  new Ingredient(WHIPPED_CREAM,1.00f));
		
		ingredientsAvaibality.put(Ingredients.get(COFFEE), MAXSTOCK);		
		ingredientsAvaibality.put(Ingredients.get(DECAF_COFFEE), MAXSTOCK);	
		ingredientsAvaibality.put(Ingredients.get(SUGAR), MAXSTOCK);		
		ingredientsAvaibality.put(Ingredients.get(CREAM), MAXSTOCK);	
		ingredientsAvaibality.put(Ingredients.get(STEAMED_MILK), MAXSTOCK);		
		ingredientsAvaibality.put(Ingredients.get(FOAMED_MILK), MAXSTOCK);	
		ingredientsAvaibality.put(Ingredients.get(ESPRESSO), MAXSTOCK);	
		ingredientsAvaibality.put(Ingredients.get(COCOA), MAXSTOCK);
		ingredientsAvaibality.put(Ingredients.get(WHIPPED_CREAM), MAXSTOCK);
						
	}
	

	
	
	public Map<Ingredient, Integer> getIngredientsAvaibality() {
		return ingredientsAvaibality;
	}

	public void setIngredientsAvaibality(Map<Ingredient, Integer> ingredientsAvaibality) {
		this.ingredientsAvaibality = ingredientsAvaibality;
	}

	@Override
	public String toString() {
		return "Inventory [Ingredients=" + Ingredients + "]";
	}
	
}
