package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 *
 * @author jodevan
 */
public class FinalFrameSecondChanceState extends NonInitialDefaultChanceState {

	public FinalFrameSecondChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		playTracker.addChance(playRecord.getChance());
		
		if (Chance.sum(
				playTracker.getChancesArray()) >= BowlingGame.MAX_SCORE) {
			// The player either scored a strike on his/her first attempt
			// or scored a spair on his/her second second attempt
			bowlingGame.setState(bowlingGame.getFinalFrameThirdChanceState());
		} else {
			bowlingGame.getTurnPlayer().addFrame(
					FrameFactory.newInstance(
							bowlingGame.getFrameNumber(),
							playTracker.getChancesArray()));
			playTracker.resetChances();
			bowlingGame.endTurn();
			if (bowlingGame.getFrameNumber() > BowlingGame.MAX_FRAMES) {
				bowlingGame.setState(bowlingGame.getGameOverState());
			} else {
				bowlingGame.setState(
						bowlingGame.getFinalFrameFirstChanceState());
			}
		}
	}
}

