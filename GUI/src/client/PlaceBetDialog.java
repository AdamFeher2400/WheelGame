package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JDialog;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.PlaceBetButtonController;
import model.enumeration.BetType;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class PlaceBetDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3566324165224531742L;
	
	private JComboBox typeField;
	private JTextField betField;
	private MainPanel mainPanel;

	public PlaceBetDialog(MainPanel parent) {
		super((JFrame)null, "Place Bet");
		
		mainPanel = parent;
		
		
		GridLayout layout = new GridLayout(1, 2);
		layout.setHgap(10);
		layout.setVgap(10);
		setLayout(layout);
		
		add(new JLabel("BetType:"));
		typeField = new JComboBox(new String[] {"BLACK", "RED", "ZEROS" });
		add(typeField);
		
		add(new JLabel("Bet:"));
		betField = new JTextField();
		add(betField);

		
		// set the position of the window
		Point p = new Point(400, 400);
		setLocation(p.x, p.y);

		// Create a message
		JPanel messagePane = new JPanel();
		// get content pane, which is usually the
		// Container of all the dialog's components.
		add(messagePane);

		// Create a button
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Bet");
		buttonPane.add(button);
		
		// set action listener on the button
		button.addActionListener(new PlaceBetButtonController(this, mainPanel));
		add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public int getBet() {
		// TODO Auto-generated method stub
		try {
			return Integer.parseInt(betField.getText());
		} catch (Exception ee) {
			return 0;
		}
	}

	public BetType getBetType() {
		// TODO Auto-generated method stub
		switch(typeField.getSelectedIndex()) {
		case 0:
			return BetType.BLACK;
		case 1:
			return BetType.RED;
		default:
			return BetType.ZEROS;
		}
	}
	
}
