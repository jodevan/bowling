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
public class SimpleFrameTest {
	
	private Frame mockFrame = Mockito.mock(Frame.class);
	
	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new SimpleFrame(mockFrame, 11, 5);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new SimpleFrame(mockFrame, 0, -10);
	}

	@Test(expected = FrameCreationException.class)
	public void expectSumChancesValuesInvalid() {
		new SimpleFrame(mockFrame, 5, 6);
	}

	@Test(expected = Test.None.class)
	public void testValidFrame() {
		new SimpleFrame(mockFrame, 5, 4);
	}
}
