package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 *
 * @author jodevan
 */
public class FinalFrameThirdChanceState extends NonInitialDefaultChanceState {

	public FinalFrameThirdChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		playTracker.addChance(playRecord.getChance());

		bowlingGame.getTurnPlayer().addFrame(
				FrameFactory.newInstance(
						bowlingGame.getFrameNumber(),
						playTracker.getChancesArray()));
		bowlingGame.endTurn();
		
		if (bowlingGame.getFrameNumber() > BowlingGame.MAX_FRAMES) {
			bowlingGame.setState(bowlingGame.getGameOverState());
		} else {
			bowlingGame.setState(bowlingGame.getFinalFrameFirstChanceState());
		}
	}
}

