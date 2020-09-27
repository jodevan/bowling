package com.jobsity.bowling.factory;

import com.jobsity.bowling.frame.FinalFrame;
import static org.junit.Assert.*;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.SimpleFrame;
import com.jobsity.bowling.frame.SpareFrame;
import com.jobsity.bowling.frame.StrikeFrame;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class FactoryTest {
	
	private Frame mockFrame = Mockito.mock(Frame.class);
	
	/*
	 * I could have written a few tests for when the factory passes invalid
	 * chances or frames. However, this scenario has already been tested when
	 * trying to instantiate frames with invalid parameters
	 */

	@Test(expected = Test.None.class)
	public void testExpectSimpleFrame() {
		Frame frame = FrameFactory.newInstance(mockFrame, new int[]{2, 4});
		assertTrue(frame instanceof SimpleFrame);

		frame = FrameFactory.newInstance(mockFrame, new int[]{0, 0});
		assertTrue(frame instanceof SimpleFrame);
	}

	@Test(expected = Test.None.class)
	public void testExpectSpareFrame() {
		Frame frame = FrameFactory.newInstance(mockFrame, new int[]{4, 6});
		assertTrue(frame instanceof SpareFrame);

		frame = FrameFactory.newInstance(
				mockFrame, new int[]{0, Frame.MAX_SCORE});
		assertTrue(frame instanceof SpareFrame);
	}

	@Test(expected = Test.None.class)
	public void testExpectStrikeFrame() {
		Frame frame = FrameFactory.newInstance(
				mockFrame, new int[]{Frame.MAX_SCORE});
		assertTrue(frame instanceof StrikeFrame);
	}

	@Test(expected = Test.None.class)
	public void testExpectFinalFrame() {
		Frame frame = FrameFactory.newInstance(null, new int[]{0, 4});
		assertTrue(frame instanceof FinalFrame);

		frame = FrameFactory.newInstance(
				null, new int[]{Frame.MAX_SCORE, 0, 0});
		assertTrue(frame instanceof FinalFrame);

		frame = FrameFactory.newInstance(
				null, new int[]{Frame.MAX_SCORE, Frame.MAX_SCORE, 9});
		assertTrue(frame instanceof FinalFrame);

	}
}
