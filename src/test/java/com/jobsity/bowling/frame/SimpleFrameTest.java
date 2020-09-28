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
public class SimpleFrameTest {
	
	private Frame mockFrame = Mockito.mock(Frame.class);
	
	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new SimpleFrame(1, mockFrame, 11, 5);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new SimpleFrame(1, mockFrame, 0, -10);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSumChancesValuesInvalid() {
		new SimpleFrame(1, mockFrame, 5, 6);
	}

	@Test(expected = Test.None.class)
	public void testValidFrame() {
		new SimpleFrame(1, mockFrame, 5, 4);
	}
	
	@Test
	public void testCalcScore() {
		assertEquals(0, new SimpleFrame(1, mockFrame, 0, 0).calcScore());
		assertEquals(9, new SimpleFrame(1, mockFrame, 2, 7).calcScore());
		assertEquals(8, new SimpleFrame(1, mockFrame, 5, 3).calcScore());
	}
	
	@Test
	public void testPrint() {
		assertEquals("0\t0", 
				new SimpleFrame(1, mockFrame, 0, 0).printChances());
		assertEquals("2\t7", 
				new SimpleFrame(1, mockFrame, 2, 7).printChances());
	}
}
