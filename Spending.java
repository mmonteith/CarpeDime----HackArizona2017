
/**
 * CarpeDime - Spending.java
 * 
 * @author Michelle Monteith
 * @author Victor Gomes
 * @author Griffin Stiller
 * 
 * Class for creating a Spending object and appropriate methods for
 * building the SpendingList. 
 * 
 */

public class Spending {
	private double priceOfItem;
	private String nameOfItem;
	private String date;

	public Spending() {
		// empty
	}

	public Spending(double priceOfItem, String nameOfItem, String date) {
		this.priceOfItem = priceOfItem;
		this.nameOfItem = nameOfItem;
		this.date = date;
	}

	// methods to get and set nameOftheItem
	public String getNameOfItem() {
		return nameOfItem;
	}

	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}

	// methods to get and set price of the item
	public double getPriceOfItem() {
		return priceOfItem;
	}

	public void setPriceOfItem(double priceOfItem) {
		this.priceOfItem = priceOfItem;
	}

	// methods to get and set the date the person got the item
	public String getDates() {
		return date;
	}

	public void setDates(String date) {
		this.date = date;
	}

}
