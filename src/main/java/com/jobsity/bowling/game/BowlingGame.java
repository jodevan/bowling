package com.jobsity.bowling.game;

import com.jobsity.bowling.game.parser.PlayRecordParser;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import com.jobsity.bowling.game.state.BowlingState;
import com.jobsity.bowling.game.state.impl.NewGameState;
import com.jobsity.bowling.player.Player;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jodevan
 */
public class BowlingGame {
	
	@Getter
	private Map<String, Player> playersMap = new LinkedHashMap<>();
	
	@Getter
	@Setter
	private BowlingState currState;
	private BowlingState newGameState;
	
	public BowlingGame() {
		newGameState = new NewGameState(this);
		currState = newGameState;
	}
	
	public void processPlayRecord(String line) 
			throws PlayRecordParseException {
		currState.play(PlayRecordParser.parsePlayRecord(line));
	}
}
