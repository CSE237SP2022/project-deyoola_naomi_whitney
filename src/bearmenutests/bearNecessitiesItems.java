package bearmenutests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bearmenu.bearItems;

class bearItemsTest {
	private bearItems bearItem;
	@BeforeEach
	void provideFoundation() { 
		// Places the foremost line per given test in providedFoundation
		bearItem = new bearItems("Classic Logo Long Sleeved Tee", 22.99, 80);
		 // name of item, cost of item, the amount available of this particular item
	}
	
	
	@Test
	void testRetrieveNameOfItem() {
		String nameOfItem = bearItem.retrieveNameOfItem();
		assertTrue("Classic Logo Long Sleeved Tee".equals(nameOfItem)); 
	}
	@Test 
	void testRetrieveCostOfItem() {
		double costOfItem = bearItem.retrieveCostOfItem(); 
		assertEquals(22.99, costOfItem, 0.05); 
	}
	@Test
	void testRetrieveTotalNumberAvailable() {
		int totalNumberAvailable = bearItem.retrieveTotalNumberAvailable(); 
		assertTrue(80 == totalNumberAvailable); 
	}
	// Our Retriever Tests Above from bearItems.java^^
	
	@Test
	void testEstablishCostOfItem() {
	    bearItem.establishCostOfItem(27.99);
	    assertEquals(27.99, bearItem.retrieveCostOfItem());
	}

	@Test
	void testEstablishTotalNumberAvailable() {
		bearItem.establishTotalNumberAvailable(67);
		assertEquals(67, bearItem.retrieveTotalNumberAvailable()); 
	}
	// Out Establishing Tests Above from bearItems.java^^

}