package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents the third and last move of the final frame
 * @author jodevan
 */
public class FinalFrameThirdChanceState extends DefaultFinalFrameState {

	public FinalFrameThirdChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		playTracker.addChance(playRecord.getChance());

		/*
		 * Otherwise, we'll process the player current frame and let
		 * endTurn() decide where to go next
		 */
		bowlingGame.getTurnPlayer().addFrame(
				FrameFactory.newInstance(
						bowlingGame.getFrameNumber(),
						playTracker.getChancesArray()));
		endTurn();
	}
}

