package com.jobsity.bowling.game.state;

import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import com.jobsity.bowling.game.parser.PlayRecord;

/**
 *
 * @author jodevan
 */
public interface BowlingState {
	
	public void play(PlayRecord playRecord) throws InvalidGameStateException;
}
