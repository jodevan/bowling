package com.jobsity.bowling.frame.print.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.print.PrintChancesBehavior;
import com.jobsity.bowling.game.BowlingGame;

/**
 *
 * @author jodevan
 */
public class PrintThreeChancesFrameBehavior implements PrintChancesBehavior {

	@Override
	public String print(Frame frame) {
		if (frame == null) {
			return new String();
		}
		Chance[] chances = frame.getChances();
		
		StringBuilder sb = new StringBuilder();
		sb.append(printChance(chances[0]));
		sb.append(PrintChancesBehavior.PRINT_SEPARATOR);
		sb.append(printChance(chances[1]));
		if (chances.length == 3) {
			sb.append(PrintChancesBehavior.PRINT_SEPARATOR);
			sb.append(printChance(chances[2]));
		}
		return sb.toString();
	}
	
	public String printChance(Chance chance) {
		return chance.getIntValue() == BowlingGame.MAX_SCORE ?
				"X" : chance.getStrValue();
	}
}
