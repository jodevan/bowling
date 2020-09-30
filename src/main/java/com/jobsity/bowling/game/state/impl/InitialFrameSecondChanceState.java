package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents the second move of the initial frame
 * @author jodevan
 */
public class InitialFrameSecondChanceState 
		extends DefaultIntermediateFrameState {

	public InitialFrameSecondChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);

		/*
		 * We can simply process the current frame and get to the initial move
		 * of the first frame again. It'll decide where to go next
		 */
		bowlingGame.getTurnPlayer().addFrame(FrameFactory.newInstance(
				bowlingGame.getFrameNumber(), 
				playTracker.getChances().get(0), chance));
		playTracker.resetChances();
		bowlingGame.setState(bowlingGame.getInitialFrameFirstChanceState());
	}
}
