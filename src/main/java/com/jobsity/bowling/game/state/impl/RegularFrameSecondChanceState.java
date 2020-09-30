package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents the second move of an intermediate frame (not first and not last)
 * @author jodevan
 */
public class RegularFrameSecondChanceState 
		extends DefaultIntermediateFrameState {

	public RegularFrameSecondChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);

		playTracker.addChance(playRecord.getChance());
		
		/*
		 * All we have to do is process the current frame and ends the player
		 * turn
		 */
		bowlingGame.getTurnPlayer().addFrame(
				FrameFactory.newInstance(
						bowlingGame.getFrameNumber(),
						playTracker.getChancesArray()));
		endTurn();
	}
}

