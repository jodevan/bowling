package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;

/**
 *
 * @author jodevan
 */
class DefaultNonInitialChanceState extends DefaultChanceState {

	public DefaultNonInitialChanceState(BowlingGame bowlingGame) {
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
		playTracker.resetChances();
		bowlingGame.endTurn();

		if (bowlingGame.getFrameNumber() < BowlingGame.MAX_FRAMES) {
			bowlingGame.setState(
					bowlingGame.getRegularFrameFirstChanceState());
		} else if (bowlingGame.getFrameNumber() == BowlingGame.MAX_FRAMES) {
			bowlingGame.setState(
					bowlingGame.getFinalFrameFirstChanceState());
		}
	}
}
