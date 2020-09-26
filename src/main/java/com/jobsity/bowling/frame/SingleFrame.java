package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.calc.impl.SingleFrameCalc;

/**
 *
 * @author jodevan
 */
public class SingleFrame extends Frame {

	public SingleFrame() {
		calcBehavior = new SingleFrameCalc();
	}	
}
