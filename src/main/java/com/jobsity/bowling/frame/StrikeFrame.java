package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintStrikeFrameBehavior;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.score.impl.StrikeFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.StrikeFrameValidator;

/**
 * Represents a frame that's a strike
 * @author jodevan
 */
public class StrikeFrame extends Frame {

	public StrikeFrame(int frameNumber, Frame nextFrame) {
		super(
				frameNumber,
				new Chance[]{new Chance(BowlingGame.MAX_SCORE)}, 
				nextFrame, 
				new StrikeFrameCalcBehavior(),
				new PrintStrikeFrameBehavior(),
				new StrikeFrameValidator());
	}

	public StrikeFrame(int frameNumber) {
		super(
				frameNumber,
				new Chance[]{new Chance(BowlingGame.MAX_SCORE)}, 
				null, 
				new StrikeFrameCalcBehavior(),
				new PrintStrikeFrameBehavior(),
				new StrikeFrameValidator());
	}
}
