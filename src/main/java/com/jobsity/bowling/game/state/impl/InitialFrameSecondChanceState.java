package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 *
 * @author jodevan
 */
public class InitialFrameSecondChanceState 
		extends DefaultNonInitialChanceState {

	public InitialFrameSecondChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);

		bowlingGame.getTurnPlayer().addFrame(FrameFactory.newInstance(
				bowlingGame.getFrameNumber(), 
				playTracker.getChances().get(0), chance));
		playTracker.resetChances();
		bowlingGame.setState(bowlingGame.getInitialFrameFirstChanceState());
	}
}
