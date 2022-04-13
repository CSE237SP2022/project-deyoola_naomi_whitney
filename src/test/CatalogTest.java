package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import catalog.Cart;
import catalog.CatalogItem;

/**
 * currently has...price, name, category, and description
 */



class CatalogTest {
	private CatalogItem item;
	
	@BeforeEach
	public void setup() {
		item = new CatalogItem(5.60, "tshirt", "apparel", "green");

	}

	@Test
	void testGetPrice() {
		//Step 1: Setup
		//Step 2: test a method
		double price = item.getPrice();
		//Step 3: assert
		assertEquals(5.60, price, 0.05);
	}
	
	@Test
	void testGetName() {
		//Step 1: Setup
		//Step 2: test a method
		String name = item.getName();
		//Step 3: assert
		assertTrue("tshirt".equals(name));
	}
	
	@Test
	void testGetCategory() {
		//Step 1: Setup
		//Step 2: test a method
		String category = item.getCategory();
		//Step 3: assert
		assertTrue("apparel".equals(category));
	}
	
	@Test
	void testGetDescription() {
		//Step 1: Setup
		//Step 2: test a method
		String description = item.getDescription();
		//Step 3: assert
		assertTrue("green".equals(description));
	}
	

}
