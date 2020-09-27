package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.ThreeChancesFrameValidator;
import com.jobsity.bowling.frame.Frame;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class ThreeChancesFrameValidatorTest {
	
	private Validator threeChancesFrameValidator = 
			new ThreeChancesFrameValidator();

	@Test
	public void testEmptyChances() {
		assertFalse(threeChancesFrameValidator.isValid(1, new int[]{}));
	}

	@Test
	public void testInvalid3Chances() {
		assertFalse(threeChancesFrameValidator.isValid(1, new int[]{-1, 3, 4}));
		assertFalse(threeChancesFrameValidator.isValid(2, new int[]{5, 4, 1}));
		assertFalse(threeChancesFrameValidator.isValid(3, new int[]{0, 0, 0}));
	}

	@Test
	public void testValid3Chances() {
		assertTrue(threeChancesFrameValidator.isValid(4, new int[]{5, 5, 8}));
		assertTrue(threeChancesFrameValidator.isValid(
				5, new int[]{Frame.MAX_SCORE, 0, 8}));
		assertTrue(threeChancesFrameValidator.isValid(
				6, new int[]{Frame.MAX_SCORE, Frame.MAX_SCORE, 9}));
	}

	@Test
	public void testValidNChances() {
		assertFalse(threeChancesFrameValidator.isValid(7, new int[]{1}));
		assertFalse(threeChancesFrameValidator.isValid(8, new int[]{1, 2}));
		assertFalse(threeChancesFrameValidator.isValid(
				9, new int[]{1, 2, 3, 4}));
	}
}
