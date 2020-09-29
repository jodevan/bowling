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
public class InitialFrameFirstChanceState extends DefaultChanceState {

	public InitialFrameFirstChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		Map<String, PlayTracker> trackerMap = bowlingGame.getPlayTrackerMap();
		PlayTracker tracker = trackerMap.get(playRecord.getPlayer());
		
		String recordPlayerName = playRecord.getPlayer();
		Chance chance = playRecord.getChance();
		
		if (tracker == null) {
			// It's the first player move ever in the game
			tracker = new PlayTracker();
			Player player = Player.builder().name(recordPlayerName).build();
			tracker.setPlayer(player);

			bowlingGame.addPlayer(player);
			bowlingGame.incrementTurn();

			// If it's a strike, we can't create this frame right away
			if (chance.getIntValue() == BowlingGame.MAX_SCORE) {
				player.addFrame(FrameFactory.newInstance(1, 
						new Chance[]{new Chance(BowlingGame.MAX_SCORE)}));
			} else {
				tracker.addChance(chance);
				bowlingGame.setState(
						bowlingGame.getInitialFrameSecondChanceState());
			}
			trackerMap.put(recordPlayerName, tracker);
		} else {
			// If we get here, it's because the first user is playing again
			// and that a new frame should start
			bowlingGame.endTurn();
			bowlingGame.setState(bowlingGame.getRegularFrameFirstChanceState());
			
			// Now we delegate the action to the new state
			bowlingGame.getState().play(playRecord);
		}
	}
}
