package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;

/**
 *
 * @author jodevan
 */
public abstract class LookAheadFrame extends Frame {
	
	public LookAheadFrame(Frame nextFrame) {
		super(nextFrame);
		if (nextFrame == null) {
			throw new FrameCreationException("The next frame can't be null");
		}
	}
}
