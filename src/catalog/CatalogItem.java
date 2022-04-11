package catalog;

/**
 * 
 * Constructors and getters: A bean that represents an item in the cart
 * Features needed: Description, Category
 * @author naomihorsford, whitney, deyoola
 *
 */

public class CatalogItem {
	
	private double price;
	private String name;
	
	public CatalogItem(double price, String name) {
		this.price = price;
		this.name = name;
	}
	
	/**
	 * getters
	 */
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	
}

