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
public class TwoChancesFrameValidatorTest {
	
	private Validator twoChancesFrameValidator = 
			new TwoChancesFrameValidator();
	private Frame mockFrame = Mockito.mock(Frame.class);

	@Test
	public void testEmptyFrame() {
		assertTrue(twoChancesFrameValidator.isValid(null, new int[]{3, 5}));
	}

	@Test
	public void testEmptyChances() {
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{}));
	}

	@Test
	public void testInvalid2Chances() {
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{-1, 3}));
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{5, 5}));
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{7, 12}));
	}

	@Test
	public void testValid2Chances() {
		assertTrue(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{1, 5}));
		assertTrue(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{0, 8}));
		assertTrue(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{4, 1}));
	}

	@Test
	public void testValidNChances() {
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{1}));
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{1, 2, 3}));
		assertFalse(twoChancesFrameValidator.isValid(
				mockFrame, new int[]{1, 2, 3, 4}));
	}
}
