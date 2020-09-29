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
public class RegularFrameFirstChanceState extends DefaultNonInitialChanceState {

	public RegularFrameFirstChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		// If it's a strike, we can't create this frame right away
		if (chance.getIntValue() == BowlingGame.MAX_SCORE) {
			bowlingGame.getTurnPlayer().addFrame(
					FrameFactory.newInstance(
							bowlingGame.getFrameNumber(), 
							new Chance[]{new Chance(BowlingGame.MAX_SCORE)}));
			endTurn();
		} else {
			playTracker.addChance(chance);
			bowlingGame.setState(
					bowlingGame.getRegularFrameSecondChanceState());
		}
	}
}
