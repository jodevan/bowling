package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Frame;
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
		
		int chance = playRecord.getChance();
		
		Player player = bowlingGame.getTurnPlayer();

		// If it's a strike, we can't create this frame right away
		if (chance == Frame.MAX_SCORE) {
			player.addFrame(
					FrameFactory.newInstance(
							bowlingGame.getFrameNumber(), 
							new int[]{Frame.MAX_SCORE}));
			tracker.resetChances();
			bowlingGame.endTurn();
			if (bowlingGame.getFrameNumber() < Frame.MAX_FRAMES) {
				bowlingGame.setState(
						bowlingGame.getRegularFrameFirstChanceState());
			} else if (bowlingGame.getFrameNumber() == Frame.MAX_FRAMES) {
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
