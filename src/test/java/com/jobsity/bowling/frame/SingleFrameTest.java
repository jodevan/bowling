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
public class SingleFrameTest {

	@Test
	public void testCalc() {
		Frame singleFrame = new SingleFrame(1, 5);
		assertEquals(6, singleFrame.calcScore());

		singleFrame = new SingleFrame(0, 8);
		assertEquals(8, singleFrame.calcScore());

		singleFrame = new SingleFrame(Frame.MAX_SCORE, 9, 4);
		assertEquals(23, singleFrame.calcScore());
	}
}
