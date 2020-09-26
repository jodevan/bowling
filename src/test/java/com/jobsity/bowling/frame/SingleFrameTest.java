package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
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
	
	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new SingleFrame(11, 5);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new SingleFrame(0, -10);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSumChancesValuesInvalid() {
		new SingleFrame(5, 6);
	}

	@Test
	public void testCalc() {
		Frame singleFrame = new SingleFrame(1, 5);
		assertEquals(6, singleFrame.calcScore());

		singleFrame = new SingleFrame(0, 8);
		assertEquals(8, singleFrame.calcScore());
	}
}
