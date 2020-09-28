package com.jobsity.bowling.frame.print.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.print.PrintChancesBehavior;

/**
 *
 * @author jodevan
 */
public class PrintStrikeFrameBehavior implements PrintChancesBehavior {

	@Override
	public String print(Frame frame) {
		if (frame == null) {
			return new String();
		}

		StringBuilder sb = new StringBuilder();
		sb.append("\t");
		sb.append("X");
		
		return sb.toString();
	}
}
