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
		new SpareFrame(1, mockFrame, 11);
	}
	
	@Test
	public void testCalcWithoutNextFrame() {
		Frame spareFrame = new SpareFrame(1, null, 8);
		assertEquals(10, spareFrame.calcScore());

		spareFrame = new SpareFrame(1, null, 4);
		assertEquals(10, spareFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSpareFrame() {
		Frame nextSpareFrame = new SpareFrame(1, mockFrame, 4);
		Frame spareFrame = new SpareFrame(1, nextSpareFrame, 8);
		assertEquals(14, spareFrame.calcScore());

		nextSpareFrame = new SpareFrame(1, mockFrame, 9);
		spareFrame = new SpareFrame(1, nextSpareFrame, 8);
		assertEquals(19, spareFrame.calcScore());
	}
	
	@Test
	public void testCalcWithNextStrikeFrame() {
		Frame nextStrikeFrame = new StrikeFrame(1, mockFrame);
		Frame spareFrame = new SpareFrame(1, nextStrikeFrame, 5);
		assertEquals(20, spareFrame.calcScore());
	}
	
	@Test
	public void testPrint() {
		assertEquals("0 /", new SpareFrame(1, mockFrame, 0).printChances());
		assertEquals("2 /", new SpareFrame(1, mockFrame, 2).printChances());
	}
	
}
