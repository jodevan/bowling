package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;

/**
 * Implements methods to be reused by the last frame
 * @author jodevan
 */
class DefaultFinalFrameState extends DefaultIntermediateFrameState {
	
	public DefaultFinalFrameState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}
	
	@Override
	public void endTurn() {
		/*
		 * Whenever a turn ends, we reset the current player chances
		 * and let the game instance finish the turn
		 */
		playTracker.resetChances();
		bowlingGame.endTurn();

		/*
		 * If we ended the turn and it happened to be the last 
		 * one (hence the frame number = 11), then we should go to the 
		 * game over state
		 */
		if (bowlingGame.getFrameNumber() > BowlingGame.MAX_FRAMES) {
			bowlingGame.setState(bowlingGame.getGameOverState());
		} else {
			/*
			 * Otherwise, we should go back to the first chance of 
			 * the last frame because it's the next player move
			 */
			bowlingGame.setState(
					bowlingGame.getFinalFrameFirstChanceState());
		}
	}
}
