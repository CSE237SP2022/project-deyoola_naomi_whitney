package catalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A class that contains a single cart; this cart could contain multiple items from BearNecessities
 * @author naomihorsford, whitney, deyoola
 *
 */

public class Cart {
	
	private List<CatalogItem> cartItems;
	private double taxRate;
	
	//public static void main(String[] args) throws IOException {
		//Cart cartOrder = new Cart();
        //Student currentStudent = registration.intro();
        //registration.processChoice(currentStudent, System.in);
		
        //Scanner fileIn = new Scanner(System.in);
		//System.out.println("Please enter item: ");
		//String selection = fileIn.nextLine();
		//System.out.println(selection);
		        
	//}
    public void display_options() {
	System.out.println("1) tshirt 1\n2) hat 2\n3) pen 3");
	System.out.print("Selection: ");
    }
    
	public void question(){
	System.out.println("Would you like to proceed or quit?");
	System.out.println("To proceed enter 1.");
	System.out.println("If you wish to quit enter 0.");

	Scanner qScan = new Scanner(System.in);
       
		switch (qScan.nextInt()){
		    case 0:
		    System.out.println ("Goodbye.");
		    break;
	  
		    case 1:
		    System.out.println ("Please continue.");
		    new Cart();
		    break;
	
		    default:
		    System.err.println ( "Sorry! Unrecognized option" );
		    break;
		}
    }
 
    public Cart() {
	Scanner inScan = new Scanner(System.in);
        display_options();
  
		switch (inScan.nextInt()) {
		    case 1:
		    System.out.println ( "You picked tshirt 1" );
		    question();
		    break;
	  
		    case 2:
		    System.out.println ( "You picked hat 2" );
		    question();
		    break;
	  
		    case 3:
		    System.out.println ( "You picked pen 3" );
		    question();
		    break;
	
		    default:
		    System.err.println ( "Unrecognized option" );
		    break;
		}
    }
 
    public static void main (String[]args) {
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

