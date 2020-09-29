package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;

/**
 *
 * @author jodevan
 */
class DefaultFinalChanceState extends DefaultNonInitialChanceState {
	
	public DefaultFinalChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}
	
	@Override
	public void endTurn() {
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
