package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import client.MainPanel;
import client.PlaceBetDialog;
import model.interfaces.Player;

public class PlaceBetButtonController implements ActionListener {

	private PlaceBetDialog par;
	private MainPanel mainPanel;
	
	public PlaceBetButtonController(PlaceBetDialog parent, MainPanel mainpar) {
		par = parent;
		mainPanel = mainpar;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int[] rows = mainPanel.getSummary().playerTable.getSelectedRows();
		if(rows.length < 1)	
			return;
		
		DefaultTableModel model = mainPanel.getSummary().getModel();
		String id = model.getValueAt(rows[0], 0).toString();
		Player player =  mainPanel.getEngine().getPlayer(id);
		
		
		
		mainPanel.getEngine().placeBet(player, par.getBet(), par.getBetType());
		model.setValueAt(player.getBet(), rows[0], 4);
		model.setValueAt(player.getBetType(), rows[0], 3);
		
		par.setVisible(false);
		par.dispose();
	}
}
