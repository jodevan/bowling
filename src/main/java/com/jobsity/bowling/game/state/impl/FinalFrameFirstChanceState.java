package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.util.Map;

/**
 *
 * @author jodevan
 */
public class FinalFrameFirstChanceState extends DefaultChanceState {

	public FinalFrameFirstChanceState(BowlingGame bowlingGame) {
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
		
		int chance = playRecord.getChance();
		
		tracker.addChance(chance);
		bowlingGame.setState(bowlingGame.getFinalFrameSecondChanceState());
	}}

