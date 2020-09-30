package com.jobsity.bowling.frame.print.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.print.PrintChancesBehavior;

/**
 * Behavior to print a spare frame
 * @author jodevan
 */
public class PrintSpareFrameBehavior implements PrintChancesBehavior {

	@Override
	public String print(Frame frame) {
		if (frame == null) {
			return new String();
		}
		
		Chance[] chances = frame.getChances();

		StringBuilder sb = new StringBuilder();
		sb.append(chances[0].getStrValue());
		sb.append(PrintChancesBehavior.PRINT_SEPARATOR);
		sb.append("/");
		return sb.toString();
	}
}
