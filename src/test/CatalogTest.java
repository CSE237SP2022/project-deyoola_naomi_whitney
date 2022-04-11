package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import catalog.Cart;
import catalog.CatalogItem;

/**
 * currently has...price and name
 * features needed: description, @ before 
 */



class CatalogTest {
	private CatalogItem item;
	
	@BeforeEach
	public void setup() {
		item = new CatalogItem(5.60, "tshirt");

	}

	@Test
	void testGetPrice() {
		//Step 1: Setup
		//CatalogItem item = new CatalogItem(5.60, "tshirt");
		//Step 2: test a method
		double price = item.getPrice();
		//Step 3: assert
		assertEquals(5.60, price, 0.05);
	}
	
	@Test
	void testGetName() {
		//Step 1: Setup
		//CatalogItem item = new CatalogItem(5.60, "tshirt");
		//Step 2: test a method
		String name = item.getName();
		//Step 3: assert
		assertTrue("tshirt".equals(name));
	}
	

}
