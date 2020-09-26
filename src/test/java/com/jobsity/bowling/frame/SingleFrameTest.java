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
		new SimpleFrame(11, 5);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new SimpleFrame(0, -10);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSumChancesValuesInvalid() {
		new SimpleFrame(5, 6);
	}

	@Test
	public void testCalc() {
		Frame singleFrame = new SimpleFrame(1, 5);
		assertEquals(6, singleFrame.calcScore());

		singleFrame = new SimpleFrame(0, 8);
		assertEquals(8, singleFrame.calcScore());
	}
}
