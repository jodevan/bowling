package com.jobsity.bowling.game.state;

import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import com.jobsity.bowling.game.parser.PlayRecord;

/**
 * Represents a state of the game.
 * This classes uses the State pattern to respond to each move based on the 
 * current state
 * @author jodevan
 */
public interface BowlingState {
	
	/**
	 * Executes a player move
	 * @param playRecord Object holding the info of the move (player and score)
	 * @throws InvalidGameStateException  If the move is invalid
	 */
	public void play(PlayRecord playRecord) throws InvalidGameStateException;
}
