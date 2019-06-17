package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.interfaces.GameEngine;

public class SpinButtonController implements ActionListener {

	private GameEngine gameEngine;
	
	public SpinButtonController(GameEngine engine) {
		gameEngine = engine;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gameEngine.spin(1, new Random().nextInt(1500) + 1500, 50);
	}
}
