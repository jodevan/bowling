package com.jobsity.bowling.game;

import com.jobsity.bowling.frame.Frame;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a player
 * @author jodevan
 */
@Data
@Builder
public class Player {

	private String name;
	
	@EqualsAndHashCode.Exclude
	private Frame frame;
	
	/**
	 * Adds the current frame. Since a frame has a reference to the next frame,
	 * we don't need to keep an array of frames, they're simply stacked up on
	 * the last player frame
	 * @param newFrame Frame to be added
	 */
	public void addFrame(Frame newFrame) {
		if (newFrame != null) {
			if (frame == null) {
				frame = newFrame;
			} else {
				Frame lastFrame = frame;
				Frame nextFrame = frame;
				while ((nextFrame = getNextFrame(lastFrame)) != null) {
					lastFrame = nextFrame;
				}
				lastFrame.setNextFrame(newFrame);
			}
		}
	}
	
	private Frame getNextFrame(Frame frame) {
		return frame.getNextFrame();
	}
}
