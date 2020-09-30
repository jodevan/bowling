package com.jobsity.bowling.score;

import com.jobsity.bowling.frame.Frame;

/**
 * A strategy pattern to define different behaviors when calculating 
 * a frame score
 * @author jodevan
 */
public interface ScoreCalcBehavior {

	// Note: this method is unit tested when testing each type of frame
	public int calculate(Frame frame);
}
