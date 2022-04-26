package catalog;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A class that contains a single cart; this cart could contain multiple items from BearNecessities
 * @author naomihorsford, whitney, deyoola
 */

public class Cart {
	
	private List<CatalogItem> cartItems;
	private double taxRate;
	
    public void welcome_display_options() {
    	System.out.println("Welcome to WashU's Bear Necessities Robot Cashier! \nPlease make a selection!");
    	System.out.println("1) tshirt \n2) hat \n3) pen");
    	System.out.print("Selection: ");
    }

	public void question1 () {
		System.out.println("Would you like to proceed or quit?");
		System.out.println("To proceed enter 1.");
		System.out.println("If you wish to quit enter 0.");

		try (Scanner qScan = new Scanner(System.in)) {
			switch (qScan.nextInt()){
			    case 0:
			    System.out.println ("Goodbye.");
			    break;
		  
			    case 1:
			    System.out.println ("Please continue.");
			    new Cart();
			    break;
		
			    default:
			    System.err.println ("Sorry! Unrecognized option");
			    break;
			}
		}
    }
 
	public void question2() {
		System.out.println("Would you like to proceed or checkout?");
		System.out.println("To continue shopping enter 1.");
		System.out.println("If you wish to checkout enter 0.");

		try (Scanner qScan = new Scanner(System.in)) {
			switch (qScan.nextInt()){
			    case 0:
			    System.out.println ("Goodbye. Thank you for shopping!");
			    break;
		  
			    case 1:
			    System.out.println ("Please continue picking items.");
			    new Cart();
			    break;
		
			    default:
			    System.err.println ("Sorry! Unrecognized option");
			    break;
			}
		}
    }
	
    public Cart() {
		try (Scanner inScan = new Scanner(System.in)) {
			
			welcome_display_options();
	  
			switch (inScan.nextInt()) {
			    case 1:
			    System.out.println ("You picked a tshirt.");
			    question2();
			    break;
		  
			    case 2:
			    System.out.println ("You picked a hat.");
			    question2();
			    break;
		  
			    case 3:
			    System.out.println ("You picked a pen.");
			    question2();
			    break;
		
			    default:
			    System.err.println ("Unrecognized option.");
			    break;
			}
		}
    }
 
    public static void main(String[]args) {
    	new Cart();
    }
    
	public void addItem(CatalogItem item) {
		cartItems.add(item);
	}
	
	public void removeItem(CatalogItem item) {
		cartItems.remove(item);
	}
	
	public int getSize() {
		return cartItems.size();
	}
 
	public double computeSubtotal() {
		double sum = 0;
		for(CatalogItem item : cartItems) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	public double computedTax() {
		return computeSubtotal() * this.taxRate;
	}
	
	public Cart(double taxRate) {
		this.cartItems = new LinkedList<>();
		this.taxRate = taxRate;
	}
}

