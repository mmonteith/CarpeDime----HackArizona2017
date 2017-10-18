import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AddIncome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnDone;

	/**
	 * Launch the application.
	 */
	public void AddIncome() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddIncome frame = new AddIncome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String text = null;
	/**
	 * Create the frame.
	 */
	public AddIncome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(148, 183, 159));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("Add Income"));

		
		JLabel lblAmount = new JLabel("Amount ($): ");
		lblAmount.setFont(new Font("Eras Light ITC", Font.PLAIN, 14));
		lblAmount.setBounds(42, 38, 93, 16);
		contentPane.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(133, 33, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		text = textField.getText();
		if(text == null)
			return;
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDone.setBounds(19, 71, 245, 29);
		contentPane.add(btnDone);
		
	}
	
	public double returnIncome(){
		
			double ret = Double.parseDouble(text);
		return ret;
	}
}