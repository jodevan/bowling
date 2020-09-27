package com.jobsity.bowling.frame;

import static org.junit.Assert.*;
import com.jobsity.bowling.exception.FrameCreationException;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class FinalFrameTest {
	
	// FinalFrame extends SingleFrame, hence the tests run for SimpleFrame
	// are also valid for FinalFrame
	
	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new FinalFrame(11, 5, 4);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new FinalFrame(10, -1, 4);
	}

	@Test(expected = FrameCreationException.class)
	public void expectThirdChanceInvalid() {
		new FinalFrame(10, 0, 14);
	}

	@Test(expected = FrameCreationException.class)
	public void expectThirdChanceNotAcceptable() {
		new FinalFrame(4, 5, 6);
	}

	@Test(expected = Test.None.class)
	public void expectThirdChanceAcceptable() {
		// A spare
		new FinalFrame(2, 8, 6);

		// A strike
		new FinalFrame(Frame.MAX_SCORE, 8, 6);

		// 2 strikes
		new FinalFrame(Frame.MAX_SCORE, Frame.MAX_SCORE, 9);
	}

	@Test
	public void testCalc() {
		Frame finalFrame = new FinalFrame(1, 5);
		assertEquals(6, finalFrame.calcScore());

		finalFrame = new FinalFrame(0, 8);
		assertEquals(8, finalFrame.calcScore());

		finalFrame = new FinalFrame(Frame.MAX_SCORE, 9, 4);
		assertEquals(23, finalFrame.calcScore());
	}
}
