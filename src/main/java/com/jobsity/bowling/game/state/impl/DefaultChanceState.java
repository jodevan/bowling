package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.BowlingState;
import com.jobsity.bowling.game.Player;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.util.Map;

/**
 * Do a initial state processing that will be used by its subclasses
 * @author jodevan
 */
abstract class DefaultChanceState implements BowlingState {
	
	protected BowlingGame bowlingGame;
	
	protected Map<String, PlayTracker> trackerMap;
	protected PlayTracker playTracker;

	protected String recordPlayerName;
	protected Chance chance;
	
	public DefaultChanceState(BowlingGame bowlingGame) {
		this.bowlingGame = bowlingGame;
		trackerMap = bowlingGame.getPlayTrackerMap();
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		playTracker = trackerMap.get(playRecord.getPlayer());
		
		recordPlayerName = playRecord.getPlayer();
		chance = playRecord.getChance();		
	}

	public boolean validateTurnPlayer(PlayRecord playRecord) {
		if (playRecord == null) {
			return false;
		}
		
		Player turnPlayer = bowlingGame.getTurnPlayer();
		String turnPlayerName = turnPlayer != null ? turnPlayer.getName() : "";
		
		return playRecord.getPlayer().equals(turnPlayerName);
	}
}
