package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	
	private String	id;
	private String	name;
	private int		points;
	
	private int		bet;
	private BetType betType;
	
	private String	state;

	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		id   = playerId;
		name = playerName;
		points = initialPoints;
	}
	
	@Override
	public String getPlayerName() {
		return name;
	}

	@Override
	public void setPlayerName(String playerName) {
		name = playerName;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String stateStr) {
		state = stateStr;
	}
	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int playerPoints) {
		points = playerPoints;
	}

	@Override
	public String getPlayerId() {
		return id;
	}

	@Override
	public boolean setBet(int playerBet) {
		if((playerBet < 0) || (playerBet > points))
			return false;
		
		bet = playerBet;
		return true;
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void setBetType(BetType playerBetType) {
		betType = playerBetType;
	}

	@Override
	public BetType getBetType() {
		return betType;
	}

	@Override
	public void resetBet() {
		betType = BetType.ZEROS;
		bet = 0;
	}
	
	public String toString() {
		String output = String.format("Player: id=%s, name=%s, bet=%d, betType=%s, points=%d",
				id, name, bet, betType.toString(), points);
		return output;
	}
}
