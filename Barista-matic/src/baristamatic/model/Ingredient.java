package baristamatic.model;

/**
 * Represent the Single Ingredient 
 *
 */
public class Ingredient implements Comparable<Ingredient> {

	private String name;

	private Float cost;

	public Ingredient() {

	}

	public Ingredient(String name, Float cost) {
		super();
		this.name = name;
		this.cost = cost;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", cost=" + cost + "]";
	}

	@Override
	public int compareTo(Ingredient o) {	
		return this.getName().compareToIgnoreCase(o.getName());
	}

}
