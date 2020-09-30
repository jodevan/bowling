package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents the second move of the final frame
 * @author jodevan
 */
public class FinalFrameSecondChanceState extends DefaultFinalFrameState {

	public FinalFrameSecondChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		playTracker.addChance(playRecord.getChance());
		
		if (Chance.sum(
				playTracker.getChancesArray()) >= BowlingGame.MAX_SCORE) {
			/*
			 * The player either scored a strike on his/her first attempt
			 * or scored a spare on his/her second second attempt, hence 
			 * he/she should go to his/her third attempt
			 */
			bowlingGame.setState(bowlingGame.getFinalFrameThirdChanceState());
		} else {
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
}

