package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 * Implements methods to be reused by the the intermediate frames
 * (not first and not last frames)
 * @author jodevan
 */
class DefaultIntermediateFrameState extends DefaultChanceState {

	public DefaultIntermediateFrameState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		if (!validateTurnPlayer(playRecord)) {
			throw new InvalidGameStateException(bowlingGame
					.getTurnPlayer().getName(), playRecord.getPlayer());
		}

		super.play(playRecord);
	}

	public void endTurn() {
		/*
		 * Whenever a turn ends, we reset the current player chances
		 * and let the game instance finish the turn
		 */
		playTracker.resetChances();
		bowlingGame.endTurn();

		/*
		 * If we ended the turn and the next frame is not the last one
		 * then we should go to the first move of the next frame
		 */
		if (bowlingGame.getFrameNumber() < BowlingGame.MAX_FRAMES) {
			bowlingGame.setState(
					bowlingGame.getRegularFrameFirstChanceState());
		} else if (bowlingGame.getFrameNumber() == BowlingGame.MAX_FRAMES) {
			// Otherwise we should go to the first move of the final frame
			bowlingGame.setState(
					bowlingGame.getFinalFrameFirstChanceState());
		}
	}
}
