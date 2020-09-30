package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.ThreeChancesFrameValidator;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.util.TestUtil;
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
	
	private ValidatorBehavior threeChancesFrameValidator = 
			new ThreeChancesFrameValidator();

	@Test
	public void testEmptyChances() {
		assertFalse(threeChancesFrameValidator.isValid(1, 
				TestUtil.toChancesArray(new int[]{})));
	}

	@Test
	public void testInvalid3Chances() {
		assertFalse(threeChancesFrameValidator.isValid(1, 
				TestUtil.toChancesArray(new int[]{-1, 3, 4})));
		assertFalse(threeChancesFrameValidator.isValid(2, 
				TestUtil.toChancesArray(new int[]{5, 4, 1})));
		assertFalse(threeChancesFrameValidator.isValid(3, 
				TestUtil.toChancesArray(new int[]{0, 0, 0})));
	}

	@Test
	public void testValid3Chances() {
		assertTrue(threeChancesFrameValidator.isValid(4, 
				TestUtil.toChancesArray(new int[]{5, 5, 8})));
		assertTrue(threeChancesFrameValidator.isValid(
				5, TestUtil.toChancesArray(
						new int[]{BowlingGame.MAX_SCORE, 0, 8})));
		assertTrue(threeChancesFrameValidator.isValid(
				6, TestUtil.toChancesArray(
						new int[]{BowlingGame.MAX_SCORE, 
							BowlingGame.MAX_SCORE, 9})));
	}

	@Test
	public void testValidNChances() {
		assertFalse(threeChancesFrameValidator.isValid(7, 
				TestUtil.toChancesArray(new int[]{1})));
		assertFalse(threeChancesFrameValidator.isValid(8, 
				TestUtil.toChancesArray(new int[]{1, 2})));
		assertFalse(threeChancesFrameValidator.isValid(
				9, TestUtil.toChancesArray(new int[]{1, 2, 3, 4})));
	}
}
