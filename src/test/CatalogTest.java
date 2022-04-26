package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import catalog.CatalogItem;


class CatalogTest {
	private CatalogItem item;
	
	/**
	 * currently has...price, name, category, and description
	 */
	
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
		String name = item.getName();

		assertTrue("tshirt".equals(name));
	}
	
	@Test
	void testGetCategory() {
		String category = item.getCategory();

		assertTrue("apparel".equals(category));
	}
	
	@Test
	void testGetDescription() {
		String description = item.getDescription();

		assertTrue("green".equals(description));
	}
	

}
