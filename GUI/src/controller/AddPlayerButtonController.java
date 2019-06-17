package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.AddPlayerDialog;
import client.MainPanel;
import model.SimplePlayer;
import model.interfaces.Player;

public class AddPlayerButtonController implements ActionListener {
	private AddPlayerDialog parent;
	private MainPanel mainPanel;
	
	public AddPlayerButtonController(AddPlayerDialog parDialog, MainPanel parPanel) {
		parent = parDialog;
		mainPanel = parPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Player player = new SimplePlayer(parent.getID(), parent.getAddName(), parent.getPoint());
		mainPanel.getEngine().addPlayer(player);
		mainPanel.getSummary().addRow(player);
		parent.setVisible(false);
		parent.dispose();
	}
}
