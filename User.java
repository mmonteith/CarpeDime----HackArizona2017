/**
 * CarpeDime - User.java
 * 
 * @author Michelle Monteith
 * @author Victor Gomes
 * @author Griffin Stiller
 * 
 * Class for creating a User object and appropriate methods for the 
 * basis of CarpeDime. 
 * 
 * 	Other required classes:
 * 		Spending.java
 * 		SpendingList.java
 */

public class User {

	private String name;
	private SpendingList spending;

	private double savingsPercent;
	private double savingsTotal;
	private double savingsCurMon;

	private double spendingsPercent;
	private double spendingsTotal;
	private double spendingsCurMon;

	public User() {
		name = null;
		spending = new SpendingList();

		savingsPercent = 0.0;
		savingsTotal   = 0.0;
		savingsCurMon  = 0.0;

		spendingsPercent = 0.0;
		spendingsTotal   = 0.0;
		spendingsCurMon  = 0.0;
	}

	/* 
	 * Parameterized constructor to create a new User object.
	 * 
	 * Parameters:
	 * 	double percentSave		the percentage of income to put into savings.
	 * 	double percentSpend		the percentage of income to put towards spending.
	 * 	double totalSave		the amount of savings to begin with.
	 * 	double totalSpend		the amount of spending money to begin with.
	 * 	String UN 				user name.
	 * 
	 * Return:
	 * 	user					initialized User object.
	 */
	public User newUser(double percentSave, double percentSpend, 
						double totalSave, double totalSpend, String UN) {

		User user = new User();

		if (UN == null) {
			System.out.println("Name cannot be empty!");
			return null;
		} else
			user.name = UN;

		if (percentSpend + percentSave > 100.0) {
			System.out.println("Saving and spending percentages exceed 100%. Please reevaluate");
			return null;
		} else {
			user.savingsPercent = percentSave / 100.0;
			user.spendingsPercent = percentSpend / 100.0;
		}

		user.savingsTotal = totalSave;
		user.spendingsTotal = totalSpend;

		user.savingsCurMon = 0.0;
		user.spendingsCurMon = 0.0;

		spending = new SpendingList();

		return user;
	}

	/*
	 * Collection of getters to access User values.
	 */
	public double getSavingsPercent() {
		return savingsPercent;
	}

	public double getSavingsTotal() {
		return savingsTotal;
	}

	public double getSavingsCurMon() {
		return savingsCurMon;
	}

	public double getSpendingsPercent() {
		return spendingsPercent;
	}

	public double getSpendingsTotal() {
		return spendingsTotal;
	}

	public double getSpendingsCurMon() {
		return spendingsCurMon;
	}

	public String getName() {
		return name;
	}

	public SpendingList getSpending() {
		return spending;
	}

	/*
	 * Adds income to the user's account. Based on their desired percentages,
	 * the income will be divided up and added to their savings and spendings
	 * for the current month.
	 * 
	 * Parameters:
	 * 	double income		amount of income to be added to the users account
	 */
	public void addIncome(double income) {

		double save = income * savingsPercent;
		double spend = income * spendingsPercent;

		savingsCurMon += save;
		spendingsCurMon += spend;
	}


	/*
	 * Adds a new transaction to the user's account. The data is stored into 
	 * their spending list and the amount spent is subtracted from their 
	 * monthly spending.
	 * 
	 * Parameters:
	 * 	String date			the date of the transaction.	
	 * 	String descrip		a short description of what was purchased.
	 * 	double spent		total amount spent on the transaction.
	 */
	public void addSpending(String date, String descrip, double spent) { 

		Spending data = new Spending(spent, descrip, date);
		spending.addBack(data);

		spendingsCurMon -= spent;

		if (spendingsCurMon <= 0)
			System.out.println("You've spent all your allocated spending money for the month.");
	}

	
	/*
	 * Prints out a monthly summary when the current month ends. All monthly
	 * variables (savingsCurMon, spendingsCurMon) are reset, and any left over
	 * funds 
	 */
	public void endOfMonth() {

		double savedThisMonth = savingsTotal - savingsCurMon;
		double leftOverSpent = spendingsCurMon;

		savingsTotal += savingsCurMon;
		spendingsTotal += spendingsCurMon;

		savingsCurMon = 0.0;
		spendingsCurMon = 0.0;

		if (savedThisMonth > 0.0)
			System.out.printf("Hey %s your savings grew by %.2f this month! Nice!! B-)\n", name, savedThisMonth);
		else
			System.out.printf("Your savings didn't grow this month :-(\n");

		if (leftOverSpent > 0.0)
			System.out.printf("You had %.2f left over for spending, it will be carried over for the next month.\n\n",
					leftOverSpent);
		else
			System.out.printf("You #TreatedYoSelf this month to the max!\n\n");

		System.out.println("Here's an overview of how you #TreatedYoSelf this month!!");
		spending.printElements();
		
		spending = new SpendingList();
	}
	
	
	/*
	 * Sets and checks for a valid savings percentage.
	 * 
	 * Parameters:
	 * 	double newPercent		the percentage to take out for savings.
	 * 
	 * Return:
	 * 	true, a valid newPercent was entered
	 *  false, an invalid newPercent was entered.
	 */
	public boolean setPercentSave(double newPercent) {

		newPercent = newPercent / 100.0;

		if (checkPercent(newPercent, spendingsPercent) == false) {
			System.out.println("The new percentage total exceeds 100%");
			return false;
		} else {
			savingsPercent = newPercent;
			return true;
		}
	}

	
	/* 	
	 * Sets and checks for a valid spending percentage.
	 * 
	 * Parameters:
	 * 	double newPercent		the percentage to take out for savings.
	 * 
	 * Return:
	 * 	true, a valid newPercent was entered
	 *  false, an invalid newPercent was entered.
	 */
	public boolean setPercentSpend(double newPercent) {

		newPercent = newPercent / 100.0;

		if (checkPercent(savingsPercent, newPercent) == false) {
			System.out.println("The new percentage total exceeds 100%");
			return false;
		} else {
			spendingsPercent = newPercent;
			return true;
		}
	}
	
	
	/*
	 * Tells the user if it's a good time to treat themselves or not.
	 * 
	 * Return:
	 * 	0	if they should probably pass.
	 * 	1	go ahead if they need to, otherwise keep saving.
	 * 	2	good time to treat themselves
	 */
	public int treatYourself(){
		if(spending.shouldYouTreatUrself() == 0){
			System.out.println("Funds are a little low, maybe after some more saving..");
			return 0;
		}
		if(spending.shouldYouTreatUrself() == 1){
			System.out.println("If you really need to, go for it. Otherwise, let's keep saving.");
			return 1;
		}
		else{
			System.out.println("Looks like it's time to treat yo'self!!");
			return 2;
		}
	}

	
	/*
	 * Checks for a valid savings and spending ratio.
	 * 
	 * Parameters:
	 * 	double save			saving percentage
	 * 	double spend		spending percentage
	 */
	private boolean checkPercent(double save, double spend) {

		if (save + spend > 1)
			return false;
		else
			return true;
	}	
}
