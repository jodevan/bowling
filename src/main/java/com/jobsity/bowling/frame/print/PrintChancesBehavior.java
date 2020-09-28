package com.jobsity.bowling.frame.print;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public interface PrintChancesBehavior {
	
	public final String PRINT_SEPARATOR = "\t";
	
	public String print(Frame frame);
	
}
