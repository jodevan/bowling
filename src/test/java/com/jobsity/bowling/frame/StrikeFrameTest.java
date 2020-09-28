package com.jobsity.bowling.frame;

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
public class StrikeFrameTest {
	
	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test(expected = Test.None.class)
	public void testValidFrame() {
		new StrikeFrame(1, mockFrame);
	}
	
	@Test
	public void testCalcWithoutNextFrame() {
		Frame strikeFrame = new StrikeFrame(1, null);
		assertEquals(10, strikeFrame.calcScore());

		strikeFrame = new StrikeFrame(1, null);
		assertEquals(10, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSimpleFrame() {
		Frame nextSimpleFrame = new SimpleFrame(1, mockFrame, 2, 7);
		Frame strikeFrame = new StrikeFrame(1, nextSimpleFrame);
		assertEquals(19, strikeFrame.calcScore());

		nextSimpleFrame = new SimpleFrame(1, mockFrame, 0, 2);
		strikeFrame = new StrikeFrame(1, nextSimpleFrame);
		assertEquals(12, strikeFrame.calcScore());

		nextSimpleFrame = new SimpleFrame(1, mockFrame, 8, 1);
		strikeFrame = new StrikeFrame(1, nextSimpleFrame);
		assertEquals(19, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSpareFrame() {
		Frame nextStrikeFrame = new SpareFrame(1, mockFrame, 5);
		Frame strikeFrame = new StrikeFrame(1, nextStrikeFrame);
		assertEquals(20, strikeFrame.calcScore());

		nextStrikeFrame = new SpareFrame(1, mockFrame, 2);
		strikeFrame = new StrikeFrame(1, nextStrikeFrame);
		assertEquals(20, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextStrikeFrame() {
		Frame nextNextSimpleFrame = new SimpleFrame(1, mockFrame, 2, 7);
		Frame nextStrikeFrame = new StrikeFrame(1, nextNextSimpleFrame);
		Frame strikeFrame = new StrikeFrame(1, nextStrikeFrame);
		assertEquals(22, strikeFrame.calcScore());

		nextNextSimpleFrame = new StrikeFrame(1, mockFrame);
		nextStrikeFrame = new StrikeFrame(1, nextNextSimpleFrame);
		strikeFrame = new StrikeFrame(1, nextStrikeFrame);
		assertEquals(30, strikeFrame.calcScore());
	}
	
	@Test
	public void testPrint() {
		assertEquals("\t\tX", new StrikeFrame(1, mockFrame).printChances());
	}
}
