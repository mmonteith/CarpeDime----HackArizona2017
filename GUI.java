import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * CarpeDime - GUI
 * 
 * @author Michelle Monteith
 * @author Victor Gomes
 * @author Griffin Stiller
 * 
 * A simple GUI for CarpeDime. Basic framework modeled after Professor Rick 
 * Mercer's BoggleGUI for CSC 127B Spring 16.
 * 
 * This GUI is UNFINISHED. It does not accurately function with the CarpeDime
 * classes, therefore example values were hardcoded in to exemplify the 
 * intentions of the GUI. 
 * 
 * We used Eclipse's WindowBuilder to build off of Professor Mercer's, as none
 * of us had previous experience creating a GUI, but decided to make an attempt
 * at it for Hack Arizona.
 */

@SuppressWarnings("serial")
public class GUI extends JFrame {

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUI window = new GUI();
					window.setVisible(true);
					window.setSize(663, 390);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application
	public GUI() throws IOException {
		newStart();
		openFile();
		initialize();
	}

	public User user = new User();
	public void newStart() throws IOException{
		StartUp start = new StartUp();
		start.StartUp();		
	}
	
	public void openFile(){
		
		String fileName = "DataToPass.txt";
		Scanner s = new Scanner(fileName);
		
		double savingsPerc = 0.0, spendingPerc = 0.0, savingsTotal = 0.0, spendingTotal = 0.0;
		String name = "";
		if(s.hasNext())
			name = s.next();
		if(s.hasNextDouble())
			savingsPerc = s.nextDouble();
		if(s.hasNextDouble())
			spendingPerc = s.nextDouble();		
		if(s.hasNextDouble())
			savingsTotal = s.nextDouble();
		if(s.hasNextDouble())
			spendingTotal = s.nextDouble();
		s.close();
		
		user = user.newUser(savingsPerc, spendingPerc, savingsTotal, spendingTotal, name);
		
	}
	private JFrame frame;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Carpe Dime");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane_1.setBackground(new Color(255, 255, 255));
		tabbedPane_1.setFont(new Font("Eras Light ITC", Font.PLAIN, 18));
		getContentPane().add(tabbedPane_1);

		JPanel overview = new JPanel();
		overview.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Overview", null, overview, null);
		tabbedPane_1.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane_1.setBackgroundAt(0, new Color(51, 153, 102));
		overview.setLayout(null);

		JLabel lblHelloName = new JLabel("Hello Hack AZ");
		lblHelloName.setBackground(new Color(169, 169, 169));
		lblHelloName.setFont(new Font("Eras Light ITC", Font.PLAIN, 18));
		lblHelloName.setBounds(27, 11, 221, 30);
		overview.add(lblHelloName);

		JButton btnAddIncome = new JButton("Add Income");
		btnAddIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddIncome addIn = new AddIncome();
				addIn.AddIncome();
				
				user.addIncome(addIn.returnIncome());
				
			}
		});

		btnAddIncome.setForeground(new Color(0, 0, 0));
		btnAddIncome.setBackground(new Color(119, 136, 153));
		btnAddIncome.setFont(new Font("Eras Light ITC", Font.PLAIN, 12));
		btnAddIncome.setBounds(293, 27, 107, 24);
		overview.add(btnAddIncome);

		JButton btnAddSpending = new JButton("Add Spending");
		btnAddSpending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSpending addSpend = new AddSpending();
				addSpend.AddSpending();
				
				user.addSpending("", "", 0.0);
			}
		});

		btnAddSpending.setFont(new Font("Eras Light ITC", Font.PLAIN, 12));
		btnAddSpending.setBounds(407, 27, 107, 24);
		overview.add(btnAddSpending);

		String savingsInfo = "Total savings: $"+user.getSavingsTotal();
		Label label_1 = new Label("Total savings: $5,236.25");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBackground(new Color(178, 203, 187));
		label_1.setBounds(27, 113, 221, 90);
		overview.add(label_1);

		Label label_2 = new Label("Savings");
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_2.setBackground(new Color(193, 214, 200));
		label_2.setBounds(27, 83, 221, 24);
		overview.add(label_2);

		Label label_3 = new Label("Spending");
		label_3.setFont(new Font("Eras Light ITC", Font.PLAIN, 15));
		label_3.setBackground(new Color(193, 214, 200));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(293, 83, 221, 24);
		overview.add(label_3);

		JLabel lblHeresYourMonthly = new JLabel("Here's your monthly overview.");
		lblHeresYourMonthly.setFont(new Font("Eras Light ITC", Font.PLAIN, 16));
		lblHeresYourMonthly.setBackground(new Color(169, 169, 169));
		lblHeresYourMonthly.setBounds(37, 34, 246, 30);
		overview.add(lblHeresYourMonthly);
		
		Label label_6 = new Label("Monthly savings: $1,002.02");
		label_6.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		label_6.setBackground(new Color(178, 203, 187));
		label_6.setBounds(27, 213, 221, 90);
		overview.add(label_6);
		
		Label label = new Label("Total spendings: $52.01");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBackground(new Color(178, 203, 187));
		label.setBounds(293, 113, 221, 90);
		overview.add(label);
		
		Label label_9 = new Label("Monthly spending left: $8.99");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_9.setBackground(new Color(178, 203, 187));
		label_9.setBounds(293, 213, 221, 90);
		overview.add(label_9);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Savings", null, panel_2, null);
		panel_2.setLayout(null);

		JButton btnChange = new JButton("Change?");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// reset savings change
			}
		});
		btnChange.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		btnChange.setBounds(390, 292, 117, 23);
		panel_2.add(btnChange);

		JLabel lblSavingForThe = new JLabel("Saving for the future");
		lblSavingForThe.setFont(new Font("Eras Light ITC", Font.PLAIN, 18));
		lblSavingForThe.setBackground(new Color(169, 169, 169));
		lblSavingForThe.setBounds(20, 11, 221, 30);
		panel_2.add(lblSavingForThe);

		Label label_5 = new Label("Your current savings percent: 55% ");
		label_5.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_5.setBackground(new Color(193, 214, 200));
		label_5.setAlignment(Label.CENTER);
		label_5.setBounds(20, 292, 363, 24);
		panel_2.add(label_5);
		
		Label label_10 = new Label("Savings TOTAL: $5,236.25");
		label_10.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_10.setBackground(new Color(193, 214, 200));
		label_10.setAlignment(Label.CENTER);
		label_10.setBounds(106, 90, 323, 24);
		panel_2.add(label_10);
		
		Label label_4 = new Label("Savings this month: $1,002.02");
		label_4.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_4.setBackground(new Color(193, 214, 200));
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(106, 135, 323, 24);
		panel_2.add(label_4);
		
		Label label_11 = new Label("Savings this year: $2,305.45");
		label_11.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_11.setBackground(new Color(193, 214, 200));
		label_11.setAlignment(Label.CENTER);
		label_11.setBounds(106, 182, 323, 24);
		panel_2.add(label_11);

		JPanel spending = new JPanel();
		spending.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Spendings", null, spending, null);
		spending.setLayout(null);

		JLabel lblMonthlySpending = new JLabel("Monthly spending");
		lblMonthlySpending.setFont(new Font("Eras Light ITC", Font.PLAIN, 18));
		lblMonthlySpending.setBackground(new Color(169, 169, 169));
		lblMonthlySpending.setBounds(22, 11, 221, 30);
		spending.add(lblMonthlySpending);

		Label label_8 = new Label("Your current spendings percent: 30%");
		label_8.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_8.setBackground(new Color(193, 214, 200));
		label_8.setAlignment(Label.CENTER);
		label_8.setBounds(22, 292, 363, 24);
		spending.add(label_8);

		JButton button = new JButton("Change?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset savings percent
			}
		});
		button.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		button.setBounds(389, 292, 117, 23);
		spending.add(button);
		
		Label label_7 = new Label("TOTAL Spendings: $52.01");
		label_7.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_7.setBackground(new Color(193, 214, 200));
		label_7.setAlignment(Label.CENTER);
		label_7.setBounds(22, 98, 238, 24);
		spending.add(label_7);
		
		Label label_12 = new Label("Spent this month: $64.52");
		label_12.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_12.setBackground(new Color(193, 214, 200));
		label_12.setAlignment(Label.CENTER);
		label_12.setBounds(22, 139, 238, 24);
		spending.add(label_12);
		
		Label label_13 = new Label("Spending Report");
		label_13.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_13.setBackground(new Color(193, 214, 200));
		label_13.setAlignment(Label.CENTER);
		label_13.setBounds(285, 98, 221, 24);
		spending.add(label_13);
		
		Label label_14 = new Label("Jan/12   Brunch    $13.26");
		label_14.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_14.setBackground(new Color(193, 214, 200));
		label_14.setBounds(285, 128, 221, 24);
		spending.add(label_14);
		
		Label label_18 = new Label("Monthly spending left: $8.99");
		label_18.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_18.setBackground(new Color(193, 214, 200));
		label_18.setAlignment(Label.CENTER);
		label_18.setBounds(22, 173, 238, 24);
		spending.add(label_18);
		
		Label label_25 = new Label("Jan/13   Hoodie     $40.22");
		label_25.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_25.setBackground(new Color(193, 214, 200));
		label_25.setBounds(285, 158, 221, 24);
		spending.add(label_25);
		
		Label label_26 = new Label("Jan/14   Coffee      $3.02");
		label_26.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_26.setBackground(new Color(193, 214, 200));
		label_26.setBounds(285, 186, 221, 24);
		spending.add(label_26);
		
		Label label_27 = new Label("Jan/15   Chipotle   $8.02");
		label_27.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_27.setBackground(new Color(193, 214, 200));
		label_27.setBounds(285, 216, 221, 24);
		spending.add(label_27);

		JPanel tys = new JPanel();
		tys.setBackground(new Color(255, 255, 255));
		tabbedPane_1.addTab("Treat Yo Self", null, tys, null);
		tys.setLayout(null);
		
		Label label_15 = new Label("You have $8.99 left over to spend this month.");
		label_15.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_15.setBackground(new Color(193, 214, 200));
		label_15.setAlignment(Label.CENTER);
		label_15.setBounds(29, 65, 473, 24);
		tys.add(label_15);
		
		JLabel lblWhenShouldYou = new JLabel("How and when should you treat yourself?");
		lblWhenShouldYou.setFont(new Font("Eras Light ITC", Font.PLAIN, 18));
		lblWhenShouldYou.setBackground(new Color(169, 169, 169));
		lblWhenShouldYou.setBounds(10, 11, 329, 30);
		tys.add(lblWhenShouldYou);
		
		Label label_16 = new Label("Our Suggestion:");
		label_16.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_16.setBackground(new Color(193, 214, 200));
		label_16.setAlignment(Label.CENTER);
		label_16.setBounds(281, 114, 221, 24);
		tys.add(label_16);
		
		Label label_17 = new Label("Walk in the park (free)");
		label_17.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_17.setBackground(new Color(193, 214, 200));
		label_17.setAlignment(Label.CENTER);
		label_17.setBounds(281, 144, 221, 44);
		tys.add(label_17);
		
		Label label_19 = new Label("Is it time to treat yo'self?");
		label_19.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_19.setBackground(new Color(193, 214, 200));
		label_19.setAlignment(Label.CENTER);
		label_19.setBounds(29, 114, 221, 24);
		tys.add(label_19);
		
		Label label_20 = new Label("It's been over a week since you");

		label_20.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_20.setBackground(new Color(193, 214, 200));
		label_20.setBounds(29, 144, 221, 44);
		tys.add(label_20);
		
		Label label_21 = new Label("last did.");
		label_21.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_21.setBackground(new Color(193, 214, 200));
		label_21.setBounds(29, 173, 221, 44);
		tys.add(label_21);
		
		Label label_22 = new Label("Go treat yo'self!!! B-)");
		label_22.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_22.setBackground(new Color(193, 214, 200));
		label_22.setBounds(29, 210, 221, 44);
		tys.add(label_22);
		
		Label label_23 = new Label("A small meal out");
		label_23.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_23.setBackground(new Color(193, 214, 200));
		label_23.setAlignment(Label.CENTER);
		label_23.setBounds(281, 173, 221, 44);
		tys.add(label_23);
		
		Label label_24 = new Label("Movie night");
		label_24.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		label_24.setBackground(new Color(193, 214, 200));
		label_24.setAlignment(Label.CENTER);
		label_24.setBounds(281, 210, 221, 44);
		tys.add(label_24);
	}
}
