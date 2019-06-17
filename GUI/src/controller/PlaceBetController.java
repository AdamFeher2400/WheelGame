package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.MainPanel;
import client.PlaceBetDialog;

public class PlaceBetController implements ActionListener {
	MainPanel mainPanel;
	
	public PlaceBetController(MainPanel parent) {
		mainPanel = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new PlaceBetDialog(mainPanel);
	}
}
