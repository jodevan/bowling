package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.calc.CalcBehavior;
import lombok.Data;

/**
 *
 * @author jodevan
 */
@Data
public abstract class Frame {

	protected CalcBehavior calcBehavior;
	private int[] chances;
	private Frame nextFrame;

	public int calcScore() {
		return calcBehavior.calc(this);
	}
}
