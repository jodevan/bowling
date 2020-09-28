package com.jobsity.bowling.game.state.exception;

/**
 *
 * @author jodevan
 */
public class InvalidGameStateException extends Exception {
	
	public InvalidGameStateException(String msg) {
		super(msg);
	}

	public InvalidGameStateException(
			String expectedPlayer, String actualPlayer) {
		super("Invalid player. Expected player: " + expectedPlayer
				+ " / Actual player: " + actualPlayer);
	}
}
