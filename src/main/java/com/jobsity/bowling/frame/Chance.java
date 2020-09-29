package com.jobsity.bowling.frame;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecordParser;
import java.util.Arrays;

/**
 *
 * @author jodevan
 */
public class Chance {
	
	private final int value;
	
	public Chance(int value) {
		this.value = value;
	}
	
	public int getIntValue() {
		return value == BowlingGame.FAULT_INT_VALUE ? 0 : value;
	}
	
	public String getStrValue() {
		return value == BowlingGame.FAULT_INT_VALUE ?
				PlayRecordParser.FAULT_STRING : "" + value;
	}
	
	public static int sum(Chance... chances) {
		if (chances == null) {
			return 0;
		}
		return Arrays.stream(chances)
				.map(chance -> chance.getIntValue())
				.reduce(0, (chance1, chance2) -> chance1 + chance2);
	}

	public static int subtract(Chance chance1, Chance chance2) {
		int intChance1 = chance1 != null ? chance1.getIntValue() : 0;
		int intChance2 = chance2 != null ? chance2.getIntValue() : 0;
		return intChance1 - intChance2;
	}
}
