package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import model.SlotImpl;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {
	
	private ArrayList<Player>				players;
	private ArrayList<GameEngineCallback>	callbacks;
	private ArrayList<Slot>					wheel;
	
	public GameEngineImpl() {
		players = new ArrayList<Player>();
		callbacks = new ArrayList<GameEngineCallback>();
		wheel = new ArrayList<Slot>();

		wheel.add(new SlotImpl(0, Color.GREEN00, 0));
		wheel.add(new SlotImpl(1, Color.RED, 	27));
		wheel.add(new SlotImpl(2, Color.BLACK, 	10));
		wheel.add(new SlotImpl(3, Color.RED, 	25));
		wheel.add(new SlotImpl(4, Color.BLACK, 	29));
		wheel.add(new SlotImpl(5, Color.RED, 	12));
		wheel.add(new SlotImpl(6, Color.BLACK, 	 8));
		wheel.add(new SlotImpl(7, Color.RED, 	19));
		wheel.add(new SlotImpl(8, Color.BLACK, 	31));
		wheel.add(new SlotImpl(9, Color.RED, 	18));
		wheel.add(new SlotImpl(10,Color.BLACK, 	 6));
		wheel.add(new SlotImpl(11,Color.RED, 	21));
		wheel.add(new SlotImpl(12,Color.BLACK, 	33));
		wheel.add(new SlotImpl(13,Color.RED, 	16));
		wheel.add(new SlotImpl(14,Color.BLACK, 	 4));
		wheel.add(new SlotImpl(15,Color.RED, 	23));
		wheel.add(new SlotImpl(16,Color.BLACK, 	35));
		wheel.add(new SlotImpl(17,Color.RED, 	14));
		wheel.add(new SlotImpl(18,Color.BLACK, 	 2));
		wheel.add(new SlotImpl(19,Color.GREEN0,  0));
		wheel.add(new SlotImpl(20,Color.BLACK,  28));
		wheel.add(new SlotImpl(21,Color.RED, 	 9));
		wheel.add(new SlotImpl(22,Color.BLACK,  26));
		wheel.add(new SlotImpl(23,Color.RED,    30));
		wheel.add(new SlotImpl(24,Color.BLACK,  11));
		wheel.add(new SlotImpl(25,Color.RED,     7));
		wheel.add(new SlotImpl(26,Color.BLACK,  20));
		wheel.add(new SlotImpl(27,Color.RED,    32));
		wheel.add(new SlotImpl(28,Color.BLACK,  17));
		wheel.add(new SlotImpl(29,Color.RED,     5));
		wheel.add(new SlotImpl(30,Color.BLACK,  22));
		wheel.add(new SlotImpl(31,Color.RED,    34));
		wheel.add(new SlotImpl(32,Color.BLACK,  15));
		wheel.add(new SlotImpl(33,Color.RED,     3));
		wheel.add(new SlotImpl(34,Color.BLACK,  24));
		wheel.add(new SlotImpl(35,Color.RED,    36));
		wheel.add(new SlotImpl(36,Color.BLACK,  13));
		wheel.add(new SlotImpl(37,Color.RED,     1));		
	}

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		Random rand = new Random();
		int slotIndex = rand.nextInt(Slot.WHEEL_SIZE);
		Slot slot = wheel.get(slotIndex);

		int delay = initialDelay;
		while(delay < finalDelay) {
			slot = wheel.get(slotIndex);
			for(GameEngineCallback cb : callbacks) {
				cb.nextSlot(slot, this);
			}
			
			delay += delayIncrement;
			slotIndex = (slotIndex + 1) % Slot.WHEEL_SIZE;
		}
		
		for(GameEngineCallback cb : callbacks) {
			cb.result(slot, this);
		}
	}

	@Override
	public void calculateResult(Slot winningSlot) {
		for(Player player : players) {
			BetType betType = player.getBetType();
			player.setState(betType.applyWinLoss(player, winningSlot));
		}
	}

	@Override
	public void addPlayer(Player player) {
		if(players.contains(player)) {
			players.remove(player);
		}
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for(Player p : players) {
			if(p.getPlayerId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		return players.remove(player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		callbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return callbacks.remove(gameEngineCallback);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Player> getAllPlayers() {
		return (Collection<Player>) players.clone();
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		player.setBetType(betType);
		return player.setBet(bet);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Slot> getWheelSlots() {
		return (Collection<Slot>) wheel.clone();
	}

}
