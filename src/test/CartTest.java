package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import catalog.Cart;
import catalog.CatalogItem;

class CartTest {
	private Cart cartOrder;
	
	@BeforeEach
	public void setup() {
		cartOrder = new Cart(0.04); //The state sales tax rate is 4.225%

	}

	@Test
	/**
	 * Adds item to cart
	 */
	void testAddItem() {
		//Step 1: setup
		CatalogItem item = new CatalogItem(5.60, "tshirt", "apparel", "green");
		
		//Step 2: test a method
		cartOrder.addItem(item);
		int items = cartOrder.getSize();
		
		//Step 3: assert
		assertEquals(1, items);
	}
	
	@Test
	/**
	 * remove item to cart
	 */
	void testRemoveItem() {
		CatalogItem item = new CatalogItem(5.60, "tshirt", "apparel", "green");

		cartOrder.removeItem(item);
		int items = cartOrder.getSize();

		assertEquals(0, items);
	}
	
	/**
	 * Calculates the sub-total for multiple items in this order
	 * @return the sum of all prices of CartItems
	 */
	@Test
	void testComputeSubtotalMultipleItems() {
		CatalogItem item = new CatalogItem(5.60, "tshirt", "apparel", "green");
		CatalogItem item2 = new CatalogItem(10.50, "hat", "apparel", "black");
		CatalogItem item3 = new CatalogItem(2.00, "pen", "supplies", "white");
		CatalogItem item4 = new CatalogItem(7.25, "notebook", "supplies", "red");
		CatalogItem item5 = new CatalogItem(1.00, "marker", "supplies", "blue");
		cartOrder.addItem(item);
		cartOrder.addItem(item2);
		cartOrder.addItem(item3);
		cartOrder.addItem(item4);
		cartOrder.addItem(item5);
		
		double subtotal = cartOrder.computeSubtotal();

		assertEquals(26.35, subtotal, 0.05);
	}
	
	/**
	 * Calculates the sub-total for all items in this order
	 * @return the sum of all prices of CartItems
	 */
	@Test
	void testComputeSubtotal() {
		CatalogItem item = new CatalogItem(5.60, "tshirt", "apparel", "green");
		cartOrder.addItem(item);

		double subtotal = cartOrder.computeSubtotal();

		assertEquals(5.60, subtotal, 0.05);
	}
	
	/**
	 * Calculates the sub-total for zero items in this order
	 * @return the sum of all prices of CartItems
	 */
	@Test
	void testComputeSubtotalNoItems() {
		
		double subtotal = cartOrder.computeSubtotal();

		assertEquals(0, subtotal, 0.05);
	}
	
	/**
	 * Calculates the tax on item(s)
	 * @return the tax
	 */
	@Test
	void testComputedTax() {
		CatalogItem item = new CatalogItem(5.60, "tshirt", "apparel", "green");
		CatalogItem item2 = new CatalogItem(10.50, "hat", "apparel", "black");
		cartOrder.addItem(item);
		cartOrder.addItem(item2);
		
		double computedTax = cartOrder.computedTax();
		
		assertEquals(0.64, computedTax, 0.1);
	}

	@Test
	void testComputeTaxForEmptyOrder() {
		double computedTax = cartOrder.computedTax();

		assertEquals(0, computedTax, 0.05);
	}
	
	
}