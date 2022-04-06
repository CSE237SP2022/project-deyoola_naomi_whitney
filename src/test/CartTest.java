package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import catalog.Cart;
import catalog.CatalogItem;

class CartTest {

	@Test
	/**
	 * Adds item to cart
	 */
	void testAddItem() {
		//Step 1: setup
		Cart c = new Cart();
		CatalogItem item = new CatalogItem(5.60, "tshirt");
		
		//Step 2: test a method
		c.addItem(item);
		int items = c.getSize();
		
		//Step 3: assert
		assertEquals(1, items);
	}
	
	/**
	 * Calculates the sub-total for multiple items in this order
	 * @return the sum of all prices of CartItems
	 */
	@Test
	void testComputeSubtotalMultipleItems() {
		//Step 1: setup
		Cart c = new Cart();
		CatalogItem item = new CatalogItem(5.60, "tshirt");
		CatalogItem item2 = new CatalogItem(10.50, "hat");
		CatalogItem item3 = new CatalogItem(2.00, "pen");
		CatalogItem item4 = new CatalogItem(7.25, "notebook");
		CatalogItem item5 = new CatalogItem(1.00, "marker");
		c.addItem(item);
		c.addItem(item2);
		c.addItem(item3);
		c.addItem(item4);
		c.addItem(item5);
		
		//Step 2: test a method
		double subtotal = c.computeSubtotal();
		
		//Step 3: assert
		assertEquals(26.35, subtotal, 0.05);
	}
	
	/**
	 * Calculates the sub-total for all items in this order
	 * @return the sum of all prices of CartItems
	 */
	@Test
	void testComputeSubtotal() {
		//Step 1: setup
		Cart c = new Cart();
		CatalogItem item = new CatalogItem(5.60, "tshirt");
		c.addItem(item);

		
		//Step 2: test a method
		double subtotal = c.computeSubtotal();
		
		//Step 3: assert
		assertEquals(5.60, subtotal, 0.05);
	}
	
	/**
	 * Calculates the sub-total for zero items in this order
	 * @return the sum of all prices of CartItems
	 */
	@Test
	void testComputeSubtotalNoItems() {
		//Step 1: setup
		Cart c = new Cart();

		
		//Step 2: test a method
		double subtotal = c.computeSubtotal();
		
		//Step 3: assert
		assertEquals(0, subtotal, 0.05);
	}

}
