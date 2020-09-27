package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.BowlingState;

/**
 *
 * @author jodevan
 */
public class NewGameState implements BowlingState {
	
	private BowlingGame game;
	
	public NewGameState(BowlingGame game) {
		// TODO: Add exception
		this.game = game;
	}

	@Override
	public void play(PlayRecord playRecord) {
		
	}
}
