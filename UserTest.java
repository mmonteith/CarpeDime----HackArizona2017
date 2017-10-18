import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {

	@Test
	public void addUser() {

		User u = new User();
		u = u.newUser(20.0, 30.0, 500.0, 100.0, "Michelle");

		assertEquals(0.2, u.getSavingsPercent(), 0.000000000001);
		assertEquals(0.3, u.getSpendingsPercent(), 0.000000000001);
		assertEquals(500.0, u.getSavingsTotal(), 0.000000000001);
		assertEquals(100.0, u.getSpendingsTotal(), 0.000000000001);
		assertEquals("Michelle", u.getName());

		assertEquals(0.0, u.getSavingsCurMon(), 0.0000001);
		assertEquals(0.0, u.getSpendingsCurMon(), 0.00001);
	}

	@Test
	public void addIncome() {

		User u = new User();
		u = u.newUser(20.0, 30.0, 500.0, 100.0, "Michelle");

		u.addIncome(340.00);

		assertEquals(68.0, u.getSavingsCurMon(), 0.0000001);
		assertEquals(102.0, u.getSpendingsCurMon(), 0.0000001);

	}

	@Test
	public void addSpending() {

		User u = new User();
		u = u.newUser(20.0, 30.0, 500.0, 100.0, "Michelle");

		u.addSpending("Jan 14", "Clothes", 50.0);

		SpendingList copy = u.getSpending();
		assertEquals(1, copy.getSize());
	}

	@Test
	public void endOfMonth() {

		User u = new User();
		u = u.newUser(20.0, 30.0, 500.0, 100.0, "Michelle");
	
		u.addIncome(340.00);
		assertEquals(68.0, u.getSavingsCurMon(), 0.0000001);
		assertEquals(102.0, u.getSpendingsCurMon(), 0.0000001);

		u.addSpending("Jan 14", "Clothes", 50.0);
		u.addSpending("Jan 15", "Makeup", 30.0);
		u.addSpending("Jan 16", "Brunch", 22.0);
		
		u.endOfMonth();
		
		assertEquals(568.0, u.getSavingsTotal(), 0.000001);
		assertEquals(100.0, u.getSpendingsTotal(), 0.000001);
		
		assertEquals(0.0, u.getSavingsCurMon(), 0.000001);
		assertEquals(0.0, u.getSpendingsCurMon(), 0.000001);

		SpendingList copy = u.getSpending();
		assertEquals(0, copy.getSize());
	}

	 @Test
	 public void endOfMonthLeftover(){
	
			User u = new User();
			u = u.newUser(20.0, 30.0, 500.0, 100.0, "Michelle");
		
			u.addIncome(340.00);
			assertEquals(68.0, u.getSavingsCurMon(), 0.0000001);
			assertEquals(102.0, u.getSpendingsCurMon(), 0.0000001);

			u.addSpending("Jan 14", "Clothes", 50.0);
			u.addSpending("Jan 15", "Makeup", 30.0);
			u.addSpending("Jan 16", "Brunch", 10.0);
			
			u.endOfMonth();
			
			assertEquals(568.0, u.getSavingsTotal(), 0.000001);
			assertEquals(112.0, u.getSpendingsTotal(), 0.000001);
			
			assertEquals(0.0, u.getSavingsCurMon(), 0.000001);
			assertEquals(0.0, u.getSpendingsCurMon(), 0.000001);

			SpendingList copy = u.getSpending();
			assertEquals(0, copy.getSize());
	
	 }
	 
	 @Test
	 public void changePercents(){
		 
			User u = new User();
			u = u.newUser(20.0, 30.0, 500.0, 100.0, "Michelle");
			
			assertEquals(0.2, u.getSavingsPercent(), 0.0000001);
			assertEquals(0.3, u.getSpendingsPercent(), 0.00000001);
			
			assertTrue(u.setPercentSave(50.0));
			assertTrue(u.setPercentSpend(40.0));
			
			assertEquals(0.5, u.getSavingsPercent(), 0.0000001);
			assertEquals(0.4, u.getSpendingsPercent(), 0.00000001);
			
			assertFalse(u.setPercentSpend(60.0));
			assertFalse(u.setPercentSave(90.0));
			
	 }

}
