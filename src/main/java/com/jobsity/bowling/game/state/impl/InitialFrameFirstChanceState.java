package com.jobsity.bowling.game.state.impl;

import com.jobsity.bowling.factory.FrameFactory;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.PlayTracker;
import com.jobsity.bowling.game.parser.PlayRecord;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import com.jobsity.bowling.game.Player;

/**
 * Represents the first move of the initial frame
 * @author jodevan
 */
public class InitialFrameFirstChanceState extends DefaultChanceState {

	public InitialFrameFirstChanceState(BowlingGame bowlingGame) {
		super(bowlingGame);
	}

	@Override
	public void play(PlayRecord playRecord) throws InvalidGameStateException {
		super.play(playRecord);
		
		if (playTracker == null) {
			// It's the first player move ever in the game
			playTracker = new PlayTracker();
			Player player = Player.builder().name(recordPlayerName).build();
			playTracker.setPlayer(player);

			bowlingGame.addPlayer(player);
			bowlingGame.incrementTurn();

			// If it's a strike, we can create this frame right away
			if (chance.getIntValue() == BowlingGame.MAX_SCORE) {
				player.addFrame(FrameFactory.newInstance(1, 
						new Chance[]{new Chance(BowlingGame.MAX_SCORE)}));
				/*
				 * In this case, we'll be in this state until the same 
				 * player plays again
				 */
			} else {
				/*
				 * Otherwise we should go to the second chance of the 
				 * current player
				 */
				playTracker.addChance(chance);
				bowlingGame.setState(
						bowlingGame.getInitialFrameSecondChanceState());
			}
			trackerMap.put(recordPlayerName, playTracker);
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
