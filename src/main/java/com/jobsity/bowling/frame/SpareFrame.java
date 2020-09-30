package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintSpareFrameBehavior;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.score.impl.SpareFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.SpareFrameValidator;

/**
 * Represents a frame that's a spare
 * @author jodevan
 */
public class SpareFrame extends Frame {
	
	public SpareFrame(int frameNumber, Frame nextFrame, Chance chance) {
		super(
				frameNumber,
				new Chance[]{chance, 
					new Chance(BowlingGame.MAX_SCORE - chance.getIntValue())}, 
				nextFrame,
				new SpareFrameCalcBehavior(),
				new PrintSpareFrameBehavior(),
				new SpareFrameValidator());
	}

	public SpareFrame(int frameNumber, Chance chance) {
		super(
				frameNumber,
				new Chance[]{chance, 
					new Chance(BowlingGame.MAX_SCORE - chance.getIntValue())}, 
				null,
				new SpareFrameCalcBehavior(),
				new PrintSpareFrameBehavior(),
				new SpareFrameValidator());
	}
}
