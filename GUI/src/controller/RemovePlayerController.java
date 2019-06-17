package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.SummaryPanel;

public class RemovePlayerController implements ActionListener {
	SummaryPanel summaryPanel = null;
	
	public RemovePlayerController(SummaryPanel parent) {
		summaryPanel = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		summaryPanel.removeSelected();
	}
}
