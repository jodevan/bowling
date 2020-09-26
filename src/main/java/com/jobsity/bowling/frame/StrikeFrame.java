package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.calc.CalcBehavior;
import com.jobsity.bowling.frame.calc.impl.StrikeFrameCalc;

/**
 *
 * @author jodevan
 */
public class StrikeFrame extends Frame {

	public StrikeFrame() {
		CalcBehavior calcBehavior = new StrikeFrameCalc();
	}
}
