import java.util.*;
import java.util.function.Supplier;
package bearmenu;

public class bearItems {
	private String nameOfItem; 
	private double costOfItem;
	private int totalNumberAvailable; 

	public bearItems{
		this.nameOfItem = nameOfItem;
		this.costOfItem = costOfItem;
		this.totalNumberAvailable = totalNumberAvailable;

	}
	public String retrieveNameOfItem(){
		return nameOfItem;
	}
	public double retrieveCostOfItem(){
		return costOfItem;
	}
	public int retrieveTotalNumberAvailable(){
		return totalNumberAvailable;
	}
	public void establishCostOfItem(double costOfItem){
		this.costOfItem = costOfItem;
	}
	public void establishTotalNumberAvailable(int totalNumberAvailable){
		this.totalNumberAvailable = totalNumberAvailable;
	}


}
