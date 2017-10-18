import java.util.Date;

/**
 * CarpeDime - SpendingList.java
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
 */

public class SpendingList {
	private SpendingNode head = null;
	private SpendingNode tail = null;
	private int size = 0;

	// Private SpendingNode class to form the SpendingList
	private class SpendingNode {
		private SpendingNode next;
		private SpendingNode prev;
		private Spending data;

		/*
		 * Parameterized SpendingNode constructor
		 * 
		 * Parameters:
		 * 	Spending data		the data for the spendingNode
		 * 	SpendingNode next	reference to the SpendingNode after.
		 * 	SpendingNode prev	reference to the SpendingNode before.
		 */
		public SpendingNode(Spending data, SpendingNode next, SpendingNode prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		// Data getter
		public Spending getData() {
			return data;
		}
	}
	
	
	// SpendingList size getter
	public int getSize() {
		return size;
	}


	/*
	 * Adds a SpendingNode to the end of the list.
	 * 
	 * Parameters:
	 * 	Spending data		data to be put into the added node.
	 */
	public void addBack(Spending data) {
		size++;
		if (head == null) {
			head = new SpendingNode(data, null, null);
			tail = head;
		} else {
			SpendingNode node = new SpendingNode(data, null, tail);
			this.tail.next = node;
			this.tail = node;
		}
	}

	/*
	 * Adds a SpendingNode to the front of the list.
	 * 
	 * Parameters:
	 * 	Spending data		data to be put into the added node.
	 */
	public void addFront(Spending data) {
		size++;
		if (head == null) {
			head = new SpendingNode(data, null, null);
			tail = head;
		} else {
			SpendingNode node = new SpendingNode(data, head, null);
			this.head.prev = node;
			this.head = node;
		}
	}


	/*
	 * Removes the node at the end of the list.
	 * 
	 * Return:
	 * 	result		Spending object removed.
	 */
	public Spending removeBack() {
		Spending result = null;
		if (head != null) {
			size--;
			result = tail.data;
			if (tail.prev != null) {
				tail.prev.next = null;
				tail = tail.prev;
			} else {
				head = null;
				tail = null;
			}
		}
		return result;
	}


	/*
	 * Remove the node at the front of the list.
	 * 
	 * Return:
	 * 	result		Spending object removed.
	 */
	public Spending removeFront() {
		Spending result = null;
		if (head != null) {
			size--;
			result = head.data;
			if (head.next != null) {
				head.next.prev = null;
				head = head.next;
			} else {
				head = null;
				tail = null;
			}
		}
		return result;
	}

	
	/*
	 * Totals up the amount spent.
	 * 
	 * Return:
	 * 	result		total of all SpendingNodes
	 */
	public double totalSpent() {
		double result = 0.0;
		SpendingNode cur = head;
		while (cur.next != null) {
			result += cur.getData().getPriceOfItem();
			cur = cur.next;
		}
		return result;
	}

	
	/*
	 * Prints out the SpendingList
	 */
	public void printElements() {
		SpendingNode cur = head;
		for (int i = 0; i < size; i++) {
			System.out.print(cur.getData().getDates() + " -- ");
			System.out.print(cur.getData().getNameOfItem() + " -- ");
			System.out.println(cur.getData().getPriceOfItem());
			cur = cur.next;
		}
	}


	/*
	 * Determines if the user should treat themselves or not based
	 * on several criteria.
	 * 
	 * Return:
	 * 	0	shouldn't treat yourself
	 * 	1	ok to treat yourself if needed, otherwise keep saving
	 * 	2	treat yourself!
	 */
	@SuppressWarnings("deprecation")
	public int shouldYouTreatUrself() {
		
		// Get date information
		Date curDate = new Date();
		int curDay = curDate.getDate();
		int curMonth = curDate.getMonth() + 1;
		
		// Get date of last spending
		SpendingNode cur = tail;
		String month = cur.getData().getDates().substring(0, 2);
		String day = cur.getData().getDates().substring(3, 5);
		int monthNum, dayNum;
		monthNum = Integer.parseInt(month);
		dayNum = Integer.parseInt(day);
		
		System.out.println("Current day and month: " + curMonth + "/" + curDay);
		System.out.println("Day and month of last spending: " + monthNum + "/" + dayNum);
		
		// Determines if the user should treat themselves: 
		// 		Longer than 7 days since last spending? Treat yo'self
		//		Between 3-7 days since last spending? Maybe
		//		Less than 3 days since last spending? Better not.
		if (monthNum != curMonth && (curMonth - monthNum) == 1) {
			if (dayNum <= 25) {
				return 2;
			} else {
				if (curDay >= 7) {
					return 2;
				} else {
					if (dayNum == 31 && curDay == 1 || curDay == 2) {
						return 0;
					} else {
						return 1;
					}
				}
			}
		}
		if (monthNum == curMonth) {
			if (curDay == dayNum) {
				return 0;
			}
			if (curDay - dayNum >= 7) {
				return 2;
			}
			if (curDay - dayNum >= 3) {
				return 1;
			}
			if (curDay - dayNum <= 2) {
				return 0;
			}
		}
		return 2;
	}
}
