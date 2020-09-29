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
 *
 * @author jodevan
 */
public class FrameFactory {

	public static Frame newInstance(int frameNumber, Chance... externalChances) {
		return newInstance(frameNumber, null, externalChances);
	}
	
	public static Frame newInstance(int frameNumber, Frame nextFrame,
			Chance... externalChances) {

		Chance[] chances = externalChances != null ?
				externalChances : new Chance[]{};

		switch (chances.length) {
			case 0:
				return new StrikeFrame(frameNumber, nextFrame);
			case 1:
				if (chances[0].getIntValue() == BowlingGame.MAX_SCORE) {
					return new StrikeFrame(frameNumber, nextFrame);
				}
				break;
			case 2:
				if (frameNumber == BowlingGame.MAX_FRAMES) {
					return new FinalFrame(frameNumber, chances[0], chances[1]);
				} else if (Chance.sum(chances[0], chances[1]) == 
						BowlingGame.MAX_SCORE) {
					return new SpareFrame(frameNumber, nextFrame, chances[0]);
				} else {
					return new SimpleFrame(
							frameNumber, nextFrame, chances[0], chances[1]);
				}
			case 3:
				return new FinalFrame(
						frameNumber, chances[0], chances[1], chances[2]);
		}
		throw new FrameCreationException("Invalid parameters");
	}
}
