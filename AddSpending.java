import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AddSpending extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void AddSpending() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSpending frame = new AddSpending();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddSpending() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(163, 193, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("Add Spending"));
		
		JLabel lblDay = new JLabel("Date: ");
		lblDay.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblDay.setBounds(23, 26, 46, 16);
		contentPane.add(lblDay);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 22, 120, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount ($): ");
		lblAmount.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblAmount.setBounds(190, 26, 78, 16);
		contentPane.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(278, 22, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description: ");
		lblNewLabel.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 80, 87, 16);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 77, 288, 63);
		contentPane.add(textArea);
		
		JLabel lblMmdd = new JLabel("mm/dd");
		lblMmdd.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblMmdd.setBounds(89, 53, 54, 16);
		contentPane.add(lblMmdd);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDone.setBounds(6, 155, 438, 29);
		contentPane.add(btnDone);
	}
}