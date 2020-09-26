package com.jobsity.bowling.factory;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.frame.FinalFrame;
import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.SimpleFrame;
import com.jobsity.bowling.frame.SpareFrame;
import com.jobsity.bowling.frame.StrikeFrame;

/**
 *
 * @author jodevan
 */
public class FrameFactory {
	
	public static Frame newInstance(Frame nextFrame,  int... externalChances) {

		int[] chances = externalChances != null ? externalChances : new int[]{};

		if (nextFrame == null) {
			switch (chances.length) {
				case 2:
					return new FinalFrame(chances[0], chances[1]);
				case 3:
					return new FinalFrame(chances[0], chances[1], chances[2]);
			}
		} else {
			switch (chances.length) {
				case 0:
					return new StrikeFrame();
				case 1:
					if (chances[0] == Frame.MAX_SCORE) {
						return new StrikeFrame();
					}
					break;
				case 2:
					if (chances[0] + chances[1] == Frame.MAX_SCORE) {
						return new SpareFrame(chances[0]);
					} else {
						return new SimpleFrame(chances[0], chances[1]);
					}
			}
		}
		throw new FrameCreationException("Invalid parameters");
	}
}
