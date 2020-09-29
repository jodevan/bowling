package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import com.jobsity.bowling.player.Player;
import java.util.Map;

/**
 *
 * @author jodevan
 */
public class InitialFrameSecondChanceState extends DefaultChanceState {

	public InitialFrameSecondChanceState(BowlingGame bowlingGame) {
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
		
		Chance chance = playRecord.getChance();
		
		Player player = bowlingGame.getTurnPlayer();
		player.addFrame(FrameFactory.newInstance(
				bowlingGame.getFrameNumber(), 
				tracker.getChances().get(0), chance));
		tracker.resetChances();
		bowlingGame.setState(bowlingGame.getInitialFrameFirstChanceState());
	}
}
