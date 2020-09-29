package com.jobsity.bowling.game.parser;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jodevan
 */
public class PlayRecordParser {

	private static final Pattern pattern = 
			Pattern.compile("^([A-Za-z]+)\\t([F0-9]+)$");
	
	public static final String FAULT_STRING = "F";
	public static final int FAULT_INT_VALUE = -1;

	public static PlayRecord parsePlayRecord(String line) 
			throws PlayRecordParseException {
		
		if (line == null || line.trim().isEmpty()) {
			throw new PlayRecordParseException("Empty play record");
		}

		Matcher matcher = pattern.matcher(line.trim());

		if (matcher.find()) {
			String playerName = matcher.group(1);
			String score = matcher.group(2);
			return PlayRecord
					.builder()
					.player(playerName)
					.chance(new Chance(FAULT_STRING.equals(score) ? 
							FAULT_INT_VALUE :
							Integer.parseInt(score)))
					.build();
		} else {
			throw new PlayRecordParseException("Invalid play record: "+ line);
		}
	}
}
