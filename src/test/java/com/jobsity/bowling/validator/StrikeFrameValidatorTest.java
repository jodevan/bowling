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
public class StrikeFrameValidatorTest {
	
	private Validator strikeFrameValidator = new StrikeFrameValidator();
	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test
	public void testEmptyFrame() {
		assertFalse(strikeFrameValidator.isValid(null, null));
	}

	@Test
	public void testEmptyChances() {
		assertFalse(strikeFrameValidator.isValid(mockFrame, new int[]{}));
	}

	@Test
	public void testInvalid1Chance() {
		assertFalse(strikeFrameValidator.isValid(mockFrame, new int[]{4}));
	}

	@Test
	public void testValid1Chance() {
		assertTrue(strikeFrameValidator.isValid(
				mockFrame, new int[]{Frame.MAX_SCORE}));
	}

	public void testValidNChances() {
		assertFalse(strikeFrameValidator.isValid(
				mockFrame, new int[]{6, 4}));
		assertFalse(strikeFrameValidator.isValid(
				mockFrame, new int[]{5, 2, 3}));
	}
}
