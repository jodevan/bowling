package com.jobsity.bowling.factory;

import com.jobsity.bowling.frame.exception.FrameCreationException;
import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.frame.FinalFrame;
import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.SimpleFrame;
import com.jobsity.bowling.frame.SpareFrame;
import com.jobsity.bowling.frame.StrikeFrame;
import com.jobsity.bowling.game.BowlingGame;

/**
 * Factory to create frames based on the frame number and the chances
 * @author jodevan
 */
public class FrameFactory {

	/**
	 * Creates a new Frame instance based on the frame number and the chances
	 * @param frameNumber Frame number
	 * @param externalChances Player chances
	 * @return The correct Frame instance based on the input
	 */
	public static Frame newInstance(int frameNumber, 
			Chance... externalChances) {
		return newInstance(frameNumber, null, externalChances);
	}
	
	/**
	 * Creates a new Frame instance based on the frame number and the chances
	 * @param frameNumber Frame number
	 * @param nextFrame Next frame that will be associated to the current Frame 
	 * @param externalChances Player chances
	 * @return The correct Frame instance based on the input
	 */
	public static Frame newInstance(int frameNumber, Frame nextFrame,
			Chance... externalChances) {

		Chance[] chances = externalChances != null ?
				externalChances : new Chance[]{};

		switch (chances.length) {
			case 0:
				// No chances mean a strike
				return new StrikeFrame(frameNumber, nextFrame);
			case 1:
				if (chances[0].getIntValue() == BowlingGame.MAX_SCORE) {
					/*
					 * If only one chance is passed and it corresponds 
					 * to the max score, it's because this frame is also
					 * a strike
					 */
					return new StrikeFrame(frameNumber, nextFrame);
				}
				break;
			case 2:
				if (frameNumber == BowlingGame.MAX_FRAMES) {
					/*
					 * If we're in the last frame, we'll have and instance
					 * that corresponds to the final frame
					 */
					return new FinalFrame(frameNumber, chances[0], chances[1]);
				} else if (Chance.sum(chances[0], chances[1]) == 
						BowlingGame.MAX_SCORE) {
					/*
					 * If we aren't in the last frame, and the chances count
					 * to the max score, then we have a spare
					 */
					return new SpareFrame(frameNumber, nextFrame, chances[0]);
				} else {
					/*
					 * Otherwise we have a regular frame
					 */
					return new SimpleFrame(
							frameNumber, nextFrame, chances[0], chances[1]);
				}
			case 3:
				/*
				 * If we have a frame with 3 chances, we're of course in the
				 * final frame
				 */
				return new FinalFrame(
						frameNumber, chances[0], chances[1], chances[2]);
		}
		/*
		 * If any of the previous conditions are fullfiled, we have 
		 * invalid parameters
		 */ 
		throw new FrameCreationException("Invalid parameters");
	}
}
