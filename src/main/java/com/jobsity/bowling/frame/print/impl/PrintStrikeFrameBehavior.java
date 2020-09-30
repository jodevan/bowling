package com.jobsity.bowling.frame.print.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.print.PrintChancesBehavior;

/**
 * Behavior to print a strike frame
 * @author jodevan
 */
public class PrintStrikeFrameBehavior implements PrintChancesBehavior {

	@Override
	public String print(Frame frame) {
		if (frame == null) {
			return new String();
		}

		StringBuilder sb = new StringBuilder();
		sb.append(PrintChancesBehavior.PRINT_SEPARATOR);
		sb.append("X");

		return sb.toString();
	}
}
