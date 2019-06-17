package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.AddPlayerDialog;
import client.MainPanel;

public class AddPlayerController implements ActionListener {
	MainPanel mainPanel = null;
	
	public AddPlayerController(MainPanel parent) {
		mainPanel = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new AddPlayerDialog(mainPanel);
	}
}
