package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents the first move of the final frame
 * @author jodevan
 */
public class FinalFrameFirstChanceState extends DefaultFinalFrameState {

	public FinalFrameFirstChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		playTracker.addChance(chance);
		
		// Once the move is done we get to the second frame
		bowlingGame.setState(bowlingGame.getFinalFrameSecondChanceState());
	}
}

