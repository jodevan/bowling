package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import com.jobsity.bowling.game.Player;
import java.util.Map;

/**
 *
 * @author jodevan
 */
public class RegularFrameFirstChanceState extends DefaultChanceState {

	public RegularFrameFirstChanceState(BowlingGame bowlingGame) {
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

		// If it's a strike, we can't create this frame right away
		if (chance.getIntValue() == BowlingGame.MAX_SCORE) {
			player.addFrame(
					FrameFactory.newInstance(
							bowlingGame.getFrameNumber(), 
							new Chance[]{new Chance(BowlingGame.MAX_SCORE)}));
			tracker.resetChances();
			bowlingGame.endTurn();
			if (bowlingGame.getFrameNumber() < BowlingGame.MAX_FRAMES) {
				bowlingGame.setState(
						bowlingGame.getRegularFrameFirstChanceState());
			} else if (bowlingGame.getFrameNumber() == BowlingGame.MAX_FRAMES) {
				bowlingGame.setState(
						bowlingGame.getFinalFrameFirstChanceState());
			}
		} else {
			tracker.addChance(chance);
			bowlingGame.setState(
					bowlingGame.getRegularFrameSecondChanceState());
		}
	}
}
