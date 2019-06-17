package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddPlayerButtonController;

public class AddPlayerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3215645349110752315L;
	
	JTextField idField;
	JTextField nameField;
	JTextField pointField;
	
	MainPanel mainPanel;

	public AddPlayerDialog(MainPanel parent) {
		super((JFrame)null, "Add Player");
		
		mainPanel = parent;
		
		GridLayout layout = new GridLayout(2, 3);
		layout.setHgap(10);
		layout.setVgap(10);
		setLayout(layout);
		
		add(new JLabel("ID:"));
		idField = new JTextField();
		add(idField);
		
		add(new JLabel("Name:"));
		nameField = new JTextField();
		add(nameField);

		add(new JLabel("Point:"));
		pointField = new JTextField();
		add(pointField);
		
		
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
		JButton button = new JButton("Save");
		buttonPane.add(button);
		
		// set action listener on the button
		button.addActionListener(new AddPlayerButtonController(this, mainPanel));
		add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public String getID() {
		// TODO Auto-generated method stub
		return idField.getText();
	}

	public String getAddName() {
		// TODO Auto-generated method stub
		return nameField.getText();
	}

	public int getPoint() {
		// TODO Auto-generated method stub
		try {
			return Integer.parseInt(pointField.getText());
		} catch (Exception e) {
			return 0;
		}
	}


}