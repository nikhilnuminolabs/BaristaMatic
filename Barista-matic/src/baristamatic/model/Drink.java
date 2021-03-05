package baristamatic.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represent the Single Drink 
 *
 */
public class Drink {

	private String name;

	private final Map<Ingredient,Integer> ingredients;

	private Float cost;

	private Boolean availabilityStatus;

	public Drink() {
		ingredients = new TreeMap<Ingredient,Integer>();
	}

	public Drink(String name, Map<Ingredient,Integer> ingredients, Boolean availabilityStatus) {
		this.name = name;
		this.ingredients = ingredients;
		this.availabilityStatus = availabilityStatus;
		this.cost = calculateCost(ingredients);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	public Float calculateCost(Map<Ingredient,Integer> ingredients) {
		Float totalCost = 0.0F;
		
		
		for (Map.Entry<Ingredient,Integer> ingredient : ingredients.entrySet()) {
			Ingredient ingredientObj = ingredient.getKey();
			totalCost += ingredientObj.getCost() * ingredient.getValue();			
		}
		return totalCost;
	}
	
	

	public Boolean isAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(Boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public Map<Ingredient,Integer> getIngredients() {
		return ingredients;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", ingredients=" + ingredients + ", cost=" + cost + ", availabilityStatus="
				+ availabilityStatus + "]";
	}

}
