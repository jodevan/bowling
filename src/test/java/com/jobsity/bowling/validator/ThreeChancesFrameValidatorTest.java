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
public class ThreeChancesFrameValidatorTest {
	
	private Validator threeChancesFrameValidator = 
			new ThreeChancesFrameValidator();
	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test
	public void testEmptyFrame() {
		assertFalse(threeChancesFrameValidator.isValid(null, null));
	}

	@Test
	public void testEmptyChances() {
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{}));
	}

	@Test
	public void testInvalid3Chances() {
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{-1, 3, 4}));
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{5, 4, 1}));
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{0, 0, 0}));
	}

	@Test
	public void testValid3Chances() {
		assertTrue(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{5, 5, 8}));
		assertTrue(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{Frame.MAX_SCORE, 0, 8}));
		assertTrue(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{Frame.MAX_SCORE, Frame.MAX_SCORE, 9}));
	}

	@Test
	public void testValidNChances() {
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{1}));
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{1, 2}));
		assertFalse(threeChancesFrameValidator.isValid(
				mockFrame, new int[]{1, 2, 3, 4}));
	}
}
