package client;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class SummaryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1323701090969145724L;
	
	public JTable playerTable;
	GameEngine gameEngine = null;
	
	SummaryPanel(GameEngine engine) {
		gameEngine = engine;
		String data[][]={ };    
		String column[]={"ID","NAME","POINT", "BETTYPE", "BET", "STATUS"};         
		playerTable=new JTable(new DefaultTableModel(data,column));
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(playerTable);    
	    add(sp);         
	}

	public void addRow(Player player) {

	    Object[] row = { player.getPlayerId(), player.getPlayerName(), player.getPoints(), player.getBetType(), player.getBet(), "" };
	    ((DefaultTableModel) playerTable.getModel()).addRow(row);
	}

	public void removeSelected() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel)playerTable.getModel();
		int[] rows = playerTable.getSelectedRows();
		for(int i = rows.length - 1; i >= 0; i --) {
			gameEngine.removePlayer(gameEngine.getPlayer(model.getValueAt(rows[i], 0).toString()));
			model.removeRow(rows[i]);
		}
	}

	public DefaultTableModel getModel() {
		// TODO Auto-generated method stub
		return (DefaultTableModel) playerTable.getModel();
	}
	
}
