package com.jobsity.bowling.frame;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class StrikeFrameTest {

	@Test
	public void testCalcWithoutNextFrame() {
		Frame strikeFrame = new StrikeFrame();
		assertEquals(Frame.MAX_SCORE, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSimpleFrame() {
		Frame strikeFrame = new StrikeFrame();
		strikeFrame.setNextFrame(new SingleFrame(4, 5));
		assertEquals(19, strikeFrame.calcScore());

		strikeFrame = new StrikeFrame();
		strikeFrame.setNextFrame(new FinalFrame(5, 5, Frame.MAX_SCORE));
		assertEquals(20, strikeFrame.calcScore());

		strikeFrame = new StrikeFrame();
		strikeFrame.setNextFrame(new FinalFrame(Frame.MAX_SCORE, 5, 2));
		assertEquals(25, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSpareFrame() {
		Frame strikeFrame = new StrikeFrame();
		strikeFrame.setNextFrame(new SpareFrame(7));
		assertEquals(20, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextStrikeFrame() {
		Frame strikeFrame = new StrikeFrame();
		Frame nextStrikeFrame = new StrikeFrame();
		nextStrikeFrame.setNextFrame(new SpareFrame(6));
		strikeFrame.setNextFrame(nextStrikeFrame);
		assertEquals(26, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextStrikeFrameWithoutNextFrame() {
		Frame strikeFrame = new StrikeFrame();
		strikeFrame.setNextFrame(new StrikeFrame());
		assertEquals(20, strikeFrame.calcScore());
	}
}
