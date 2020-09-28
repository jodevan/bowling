package com.jobsity.bowling.frame.print.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.print.PrintChancesBehavior;

/**
 *
 * @author jodevan
 */
public class PrintSpareFrameBehavior implements PrintChancesBehavior {

	@Override
	public String print(Frame frame) {
		if (frame == null) {
			return new String();
		}
		
		int[] chances = frame.getChances();

		StringBuilder sb = new StringBuilder();
		sb.append(chances[0]);
		sb.append("\t");
		sb.append("/");
		
		
		return sb.toString();
	}
}
