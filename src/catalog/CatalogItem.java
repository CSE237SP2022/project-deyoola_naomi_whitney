package catalog;

import java.io.IOException;
import java.util.Scanner;


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
	private String category;
	private String description;


	
	public CatalogItem(double price, String name, String category, String description) {
		this.price = price;
		this.name = name;
		this.category = category;
		this.description = description;
	}

	
	/**
	 * getters
	 * @param selection 
	 */
	public  double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	public String toString() {
		return this.name+" "+this.price;
	}
	
}

