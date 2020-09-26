package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;
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
public class SimpleFrameValidatorTest {
	
	private Validator simpleFrameValidator = new SimpleFrameValidator();
	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test
	public void testEmptyFrame() {
		assertFalse(simpleFrameValidator.isValid(null, null));
	}
	
	@Test
	public void testEmptyChances() {
		assertFalse(simpleFrameValidator.isValid(mockFrame, new int[]{}));
	}

	// Since SimpleFrameValidator extends TwoChancesFrameValidator,
	// we don't need to add so many test cases

	@Test
	public void testInvalidChances() {
		assertFalse(simpleFrameValidator.isValid(mockFrame, new int[]{4, 6}));
	}

	@Test
	public void testValidChances() {
		assertTrue(simpleFrameValidator.isValid(mockFrame, new int[]{4, 4}));
	}
}
