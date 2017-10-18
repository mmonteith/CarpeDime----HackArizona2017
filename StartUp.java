import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StartUp {

	private JFrame frame;
	private JTextField txtFirstnameLastname;
	private JLabel lblHowMuchMoney;

	private JLabel lblHowMuchMoney_1;
	private JTextField txtEnterAnAmount;
	private JLabel lblHowMuchMoney_2;
	private JTextField txtEnterAnAmount_1;
	private JLabel lblWelcomeToCarpe;
	private JSlider slider;
	private JSlider slider_1;

	private static String name;
	private static double percentSavings, percentSpending, savingStart, spendingStart;


	/**
	 * Launch the application.
	 */
	public void StartUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUp window = new StartUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public static boolean isParsable(String input) {
		boolean parsable = true;
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			parsable = false;
		}
		return parsable;
	}

	public StartUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(163, 193, 173));
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JButton btnHello = new JButton("Done");
		btnHello.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		btnHello.setBounds(315, 377, 92, 23);
		btnHello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ // after the DONE button is pressed
				frame.setVisible(false);
				
				String fileName = "DataToPass.txt";
				FileWriter writer = null;
				try {
					writer = new FileWriter(fileName);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				name = txtFirstnameLastname.getText();
				try {
					writer.write(name + " ");
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				
				percentSavings = slider.getValue();
				try {
					writer.write(String.valueOf(percentSavings) + " ");
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				percentSpending = slider_1.getValue();
				try {
					writer.write(String.valueOf(percentSpending) + " ");
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				savingStart = Double.parseDouble(txtEnterAnAmount_1.getText());
				try {
					writer.write(String.valueOf(savingStart) + " ");
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				spendingStart = Double.parseDouble(txtEnterAnAmount.getText());
				try {
					writer.write(String.valueOf(spendingStart) + " ");
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				try {
					writer.flush();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				frame.dispose();
			}
		});
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		lblWelcomeToCarpe = new JLabel("Welcome to Carpe Dime!");
		lblWelcomeToCarpe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCarpe.setFont(new Font("Eras Demi ITC", Font.PLAIN, 18));
		lblWelcomeToCarpe.setBounds(87, 11, 259, 25);
		frame.getContentPane().add(lblWelcomeToCarpe);
		
		JLabel lblEnterYourName = new JLabel("Enter your name");
		lblEnterYourName.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblEnterYourName.setBounds(36, 50, 160, 25);
		frame.getContentPane().add(lblEnterYourName);
		
		JLabel lblNewLabel = new JLabel("How much money do you want to save each month? (%)");
		lblNewLabel.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblNewLabel.setBounds(43, 92, 347, 25);
		frame.getContentPane().add(lblNewLabel);
		
		slider_1 = new JSlider();
		slider_1.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		slider_1.setBackground(new Color(133, 172, 146));
		slider_1.setBounds(43, 215, 347, 45);
		frame.getContentPane().add(slider_1, "cell 1 6");
		slider_1.setMajorTickSpacing(10);
		slider_1.setMinorTickSpacing(5);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinimum(0);
		slider_1.setMaximum(100);
		
		lblHowMuchMoney = new JLabel("How much money do you want to use to Treat Yo'Self? (%)");
		lblHowMuchMoney.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblHowMuchMoney.setBounds(37, 196, 360, 14);
		frame.getContentPane().add(lblHowMuchMoney);
		
		slider = new JSlider();
		slider.setBackground(new Color(133, 172, 146));
		slider.setForeground(new Color(0, 0, 0));
		slider.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		slider.setBounds(43, 128, 347, 45);
		frame.getContentPane().add(slider);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(0);
		slider.setMaximum(100);
		
		
		lblHowMuchMoney_1 = new JLabel("How much money will start out in your Treat Yo'Self account?");
		lblHowMuchMoney_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowMuchMoney_1.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblHowMuchMoney_1.setBounds(30, 285, 373, 14);
		frame.getContentPane().add(lblHowMuchMoney_1);
		
		txtEnterAnAmount = new JTextField();
		txtEnterAnAmount.setBounds(43, 310, 229, 20);
		txtEnterAnAmount.setText("Enter an amount $");
		frame.getContentPane().add(txtEnterAnAmount);
		txtEnterAnAmount.setColumns(10);
		
		lblHowMuchMoney_2 = new JLabel("How much money will start out in your savings account?");
		lblHowMuchMoney_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowMuchMoney_2.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblHowMuchMoney_2.setBounds(37, 341, 360, 14);
		frame.getContentPane().add(lblHowMuchMoney_2);
		
		txtEnterAnAmount_1 = new JTextField();
		txtEnterAnAmount_1.setBounds(43, 366, 229, 20);
		txtEnterAnAmount_1.setText("Enter an Amount $");
		frame.getContentPane().add(txtEnterAnAmount_1);
		txtEnterAnAmount_1.setColumns(10);
		frame.getContentPane().add(btnHello);
		
		txtFirstnameLastname = new JTextField();
		txtFirstnameLastname.setBounds(152, 53, 241, 20);
		txtFirstnameLastname.setText("Name (First Last)");
		frame.getContentPane().add(txtFirstnameLastname);
		txtFirstnameLastname.setColumns(10);
	}

	
}