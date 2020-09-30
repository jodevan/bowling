package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents a game over state
 * @author jodevan
 */
public class GameOverState extends DefaultChanceState {

	public GameOverState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		/*
		 * If we try any move when the game is in this state, we should 
		 * get an exception
		 */
		throw new InvalidGameStateException("The game is over");
	}
}
