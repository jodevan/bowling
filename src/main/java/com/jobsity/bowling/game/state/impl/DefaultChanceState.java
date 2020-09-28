package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.BowlingState;
import com.jobsity.bowling.player.Player;

/**
 *
 * @author jodevan
 */
public abstract class DefaultChanceState implements BowlingState {
	
	protected BowlingGame bowlingGame;
	
	public DefaultChanceState(BowlingGame bowlingGame) {
		this.bowlingGame = bowlingGame;
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
