package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.calc.CalcBehavior;
import com.jobsity.bowling.frame.calc.impl.SpareFrameCalc;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends Frame {

	public SpareFrame() {
		CalcBehavior calcBehavior = new SpareFrameCalc();
	}
}
