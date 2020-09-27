package com.jobsity.bowling.frame;

import static org.junit.Assert.*;

import com.jobsity.bowling.exception.FrameCreationException;
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

	@Test(expected = FrameCreationException.class)
	public void expectNextFrameInvalid() {
		new StrikeFrame(null);
	}

	@Test(expected = Test.None.class)
	public void testValidFrame() {
		new StrikeFrame(mockFrame);
	}
	
	@Test
	public void testCalcWithNextSimpleFrame() {
		Frame nextSimpleFrame = new SimpleFrame(mockFrame, 2, 7);
		Frame strikeFrame = new StrikeFrame(nextSimpleFrame);
		assertEquals(19, strikeFrame.calcScore());

		nextSimpleFrame = new SimpleFrame(mockFrame, 0, 2);
		strikeFrame = new StrikeFrame(nextSimpleFrame);
		assertEquals(12, strikeFrame.calcScore());

		nextSimpleFrame = new SimpleFrame(mockFrame, 8, 1);
		strikeFrame = new StrikeFrame(nextSimpleFrame);
		assertEquals(19, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSpareFrame() {
		Frame nextStrikeFrame = new SpareFrame(mockFrame, 5);
		Frame strikeFrame = new StrikeFrame(nextStrikeFrame);
		assertEquals(20, strikeFrame.calcScore());

		nextStrikeFrame = new SpareFrame(mockFrame, 2);
		strikeFrame = new StrikeFrame(nextStrikeFrame);
		assertEquals(20, strikeFrame.calcScore());
	}

	@Test
	public void testCalcWithNextStrikeFrame() {
		Frame nextNextSimpleFrame = new SimpleFrame(mockFrame, 2, 7);
		Frame nextStrikeFrame = new StrikeFrame(nextNextSimpleFrame);
		Frame strikeFrame = new StrikeFrame(nextStrikeFrame);
		assertEquals(22, strikeFrame.calcScore());

		nextNextSimpleFrame = new StrikeFrame(mockFrame);
		nextStrikeFrame = new StrikeFrame(nextNextSimpleFrame);
		strikeFrame = new StrikeFrame(nextStrikeFrame);
		assertEquals(30, strikeFrame.calcScore());
	}

}
