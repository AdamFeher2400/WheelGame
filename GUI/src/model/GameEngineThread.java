package model;

import java.util.ArrayList;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineThread implements Runnable {

	GameEngineGUI engine;
	int initialDelay, finalDelay, delayIncrement;
	
	   public GameEngineThread(GameEngineGUI gameEngine, int init, int fn, int delay) {
		// TODO Auto-generated constructor stub
		   engine = gameEngine;
		   initialDelay = init;
		   finalDelay = fn;
		   delayIncrement = delay;
	   }
	
	public void run() {
		try {
		   int slotIndex = engine.getSlotIndex();
		   ArrayList<Slot> wheel = (ArrayList<Slot>) engine.getWheelSlots();
		   Slot slot = wheel.get(slotIndex);
	
		   int delay = initialDelay;
		   Thread.sleep(initialDelay);
		   while(delay < finalDelay) {
			   slot = wheel.get(slotIndex);
			   for(GameEngineCallback cb : engine.getCallbacks()) {
				   cb.nextSlot(slot, engine);
			   }
			
			   delay += delayIncrement;
			   Thread.sleep(delayIncrement);
			   slotIndex = (slotIndex + 1) % Slot.WHEEL_SIZE;
		   }
		
		   for(GameEngineCallback cb : engine.getCallbacks()) {
			   cb.result(slot, engine);
		   }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}

}
