package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class SpareFrameTest {

	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new SpareFrame(mockFrame, 11);
	}

	@Test(expected = Test.None.class)
	public void testValidFrame() {
		new SpareFrame(mockFrame, 5);
	}
	
	@Test
	public void testCalcWithNextSpareFrame() {
		Frame nextSpareFrame = new SpareFrame(mockFrame, 4);
		Frame spareFrame = new SpareFrame(nextSpareFrame, 8);
		assertEquals(14, spareFrame.calcScore());

		nextSpareFrame = new SpareFrame(mockFrame, 9);
		spareFrame = new SpareFrame(nextSpareFrame, 8);
		assertEquals(19, spareFrame.calcScore());
	}

	@Test
	public void testCalcWithNextStrikeFrame() {
		Frame nextStrikeFrame = new StrikeFrame(mockFrame);
		Frame spareFrame = new SpareFrame(nextStrikeFrame, 5);
		assertEquals(20, spareFrame.calcScore());
	}
}
