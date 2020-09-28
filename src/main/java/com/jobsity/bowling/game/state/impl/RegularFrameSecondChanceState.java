package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.BowlingState;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.util.Map;

/**
 *
 * @author jodevan
 */
public class RegularFrameSecondChanceState extends DefaultChanceState {

	public RegularFrameSecondChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		
		if (!validateTurnPlayer(playRecord)) {
			throw new InvalidGameStateException(bowlingGame
					.getTurnPlayer().getName(), playRecord.getPlayer());
		}

		Map<String, PlayTracker> trackerMap = bowlingGame.getPlayTrackerMap();
		PlayTracker tracker = trackerMap.get(playRecord.getPlayer());
		
		tracker.addChance(playRecord.getChance());
		
		bowlingGame.getTurnPlayer().addFrame(
				FrameFactory.newInstance(
						bowlingGame.getFrameNumber(),
						tracker.getChancesArray()));

		tracker.resetChances();
		bowlingGame.endTurn();
		
		if (bowlingGame.getFrameNumber() < Frame.MAX_FRAMES) {
			bowlingGame.setState(bowlingGame.getRegularFrameFirstChanceState());
		} else if (bowlingGame.getFrameNumber() == Frame.MAX_FRAMES) {
			bowlingGame.setState(bowlingGame.getFinalFrameFirstChanceState());
		} else {
			throw new InvalidGameStateException("No more than "
					+ Frame.MAX_SCORE + " are allowed");
		}
	}
}

