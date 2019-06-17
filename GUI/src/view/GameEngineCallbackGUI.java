package view;

import javax.swing.table.DefaultTableModel;

import client.MainPanel;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackGUI implements GameEngineCallback
{
	MainPanel mainPanel = null;
   
   public GameEngineCallbackGUI()
   {
   }
   
   public void setMainPanel(MainPanel panel) {
	   mainPanel = panel;
   }

   @Override
   public void nextSlot(Slot slot, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	   mainPanel.getRoulette().nextSlot(slot.getPosition());
   }

   @Override
   public void result(Slot result, GameEngine engine)
   {
      // final results logged at Level.INFO
//	  engine.calculateResult(result);
	  DefaultTableModel model = mainPanel.getSummary().getModel();
	  for(int i = model.getRowCount() - 1; i >= 0; i --) {
		  String id = model.getValueAt(i, 0).toString();
		  Player player = engine.getPlayer(id);
		  player.resetBet();
		  model.setValueAt(player.getPoints(), i, 2);
		  model.setValueAt(player.getBetType(), i, 3);
		  model.setValueAt(player.getBet(), i, 4);
		  model.setValueAt(player.getState(), i, 5);
	  }
   }
}