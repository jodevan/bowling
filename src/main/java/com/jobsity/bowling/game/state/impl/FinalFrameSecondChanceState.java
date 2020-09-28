package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.util.Map;

/**
 *
 * @author jodevan
 */
public class FinalFrameSecondChanceState extends DefaultChanceState {

	public FinalFrameSecondChanceState(BowlingGame bowlingGame) {
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
		
		if (tracker.sumChances() >= BowlingGame.MAX_SCORE) {
			// The player either scored a strike on his/her first attempt
			// or scored a spair on his/her second second attempt
			bowlingGame.setState(bowlingGame.getFinalFrameThirdChanceState());
		} else {
			bowlingGame.getTurnPlayer().addFrame(
					FrameFactory.newInstance(
							bowlingGame.getFrameNumber(),
							tracker.getChancesArray()));
			tracker.resetChances();
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

