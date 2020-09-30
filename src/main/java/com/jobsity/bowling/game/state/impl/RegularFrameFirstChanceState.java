package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Represents the first move of an intermediate frame (not first and not last)
 * @author jodevan
 */
public class RegularFrameFirstChanceState 
		extends DefaultIntermediateFrameState {

	public RegularFrameFirstChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		/*
		 * If it's a strike, we can create this frame right away and ends this
		 * player turn
		 */
		if (chance.getIntValue() == BowlingGame.MAX_SCORE) {
			bowlingGame.getTurnPlayer().addFrame(
					FrameFactory.newInstance(
							bowlingGame.getFrameNumber(), 
							new Chance[]{new Chance(BowlingGame.MAX_SCORE)}));
			endTurn();
		} else {
			// Otherwise we should go to the second player move
			playTracker.addChance(chance);
			bowlingGame.setState(
					bowlingGame.getRegularFrameSecondChanceState());
		}
	}
}
