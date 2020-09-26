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
public class SpareFrameValidatorTest {

	private Validator spareFrameValidator = new SpareFrameValidator();
	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test
	public void testEmptyFrame() {
		assertFalse(spareFrameValidator.isValid(null, null));
	}

	@Test
	public void testEmptyChances() {
		assertFalse(spareFrameValidator.isValid(mockFrame, new int[]{}));
	}

	@Test
	public void testInvalid2Chances() {
		assertFalse(spareFrameValidator.isValid(mockFrame, new int[]{-1, 3}));
		assertFalse(spareFrameValidator.isValid(mockFrame, new int[]{5, 4}));
		assertFalse(spareFrameValidator.isValid(mockFrame, new int[]{11, 0}));
	}

	@Test
	public void testValid2Chances() {
		assertTrue(spareFrameValidator.isValid(mockFrame, new int[]{5, 5}));
		assertTrue(spareFrameValidator.isValid(mockFrame, new int[]{2, 8}));
		assertTrue(spareFrameValidator.isValid(
				mockFrame, new int[]{0, Frame.MAX_SCORE}));
	}

	@Test
	public void testValidNChances() {
		assertFalse(spareFrameValidator.isValid(mockFrame, new int[]{5, 2, 3}));
		assertFalse(spareFrameValidator.isValid(
				mockFrame, new int[]{1, 2, 3, 6}));
	}
}
