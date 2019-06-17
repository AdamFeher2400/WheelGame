package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import controller.*;
import model.GameEngineGUI;
import model.interfaces.GameEngine;
import view.*;

public class MainPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065043093153081221L;
	
	private static String statusNames[] = { "Come In Spinner", "The Loser", "The Dabbler" };
	
    public GameEngine gameEngine = new GameEngineGUI();
    public Roulette roulette;
    public SummaryPanel summary;
    
    public GameEngine getEngine() {
    	return gameEngine;
    }
    
    public SummaryPanel getSummary() {
    	return summary;
    }

	public Roulette getRoulette() {
		// TODO Auto-generated method stub
		return roulette;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MainPanel() {
		
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		GameEngineCallbackGUI guiCallback = new GameEngineCallbackGUI();
		guiCallback.setMainPanel(this);
		gameEngine.addGameEngineCallback(guiCallback);
		
	    roulette = new Roulette("img/Basic_roulette_wheel_1024x1024.png");
	    summary = new SummaryPanel(gameEngine);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu playerMenu = new JMenu("Player");
		JMenuItem addPlayer = new JMenuItem("Add Player");
		addPlayer.addActionListener(new AddPlayerController(this));
		playerMenu.add(addPlayer);
		JMenuItem removePlayer = new JMenuItem("Remove Player");
		removePlayer.addActionListener(new RemovePlayerController(summary));
		playerMenu.add(removePlayer);
        menuBar.add(playerMenu);
        
        JMenu betMenu = new JMenu("Bet");
		JMenuItem placeBet = new JMenuItem("Place Bet");
		placeBet.addActionListener(new PlaceBetController(this));
		betMenu.add(placeBet);
        menuBar.add(betMenu);
        
        setJMenuBar(menuBar);
		

	    JToolBar toolbar = new JToolBar();
	    
	    JButton spinButton = new JButton("Spin");
	    spinButton.addActionListener(new SpinButtonController(gameEngine));
	    toolbar.add(spinButton);
	    
	    JComboBox statusCombo = new JComboBox(statusNames);
	    toolbar.add(statusCombo);
	    
	    toolbar.setFloatable(false);
	    add(toolbar, BorderLayout.NORTH);
	    
        
        JPanel splitPane = new JPanel(new GridLayout(1, 2));
        splitPane.add(roulette);
        splitPane.add(summary);
        roulette.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        summary.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        splitPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
        
        add(splitPane, BorderLayout.CENTER);
		
        JLabel statusBar = new JLabel("Started", JLabel.RIGHT);
        statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        add(statusBar, BorderLayout.SOUTH);
        	    
        pack();
        setLocationRelativeTo(null);
        setSize(1000, 600);
        setMinimumSize(new Dimension(1000, 600));
        setPreferredSize(new Dimension(1000, 600));
        setVisible(true);
	    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
