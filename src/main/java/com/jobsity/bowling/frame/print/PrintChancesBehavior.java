package com.jobsity.bowling.frame.print;

import com.jobsity.bowling.frame.Frame;

/**
 * A strategy pattern to define different behaviors when printing a frame
 * @author jodevan
 */
public interface PrintChancesBehavior {
	
	public final String PRINT_SEPARATOR = "\t";
	
	// Note: this method is unit tested when testing each type of frame
	public String print(Frame frame);
	
}
