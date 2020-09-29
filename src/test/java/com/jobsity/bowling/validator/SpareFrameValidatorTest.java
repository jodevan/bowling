package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.SpareFrameValidator;
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
public class SpareFrameValidatorTest {

	private Validator spareFrameValidator = new SpareFrameValidator();

	@Test
	public void testEmptyChances() {
		assertFalse(spareFrameValidator.isValid(1, 
				TestUtil.toChancesArray(new int[]{})));
	}
	
	@Test
	public void testInvalid2Chances() {
		assertFalse(spareFrameValidator.isValid(2, 
				TestUtil.toChancesArray(new int[]{-3, 3})));
		assertFalse(spareFrameValidator.isValid(3, 
				TestUtil.toChancesArray(new int[]{5, 4})));
		assertFalse(spareFrameValidator.isValid(4, 
				TestUtil.toChancesArray(new int[]{11, 0})));
	}

	@Test
	public void testValid2Chances() {
		assertTrue(spareFrameValidator.isValid(5, 
				TestUtil.toChancesArray(new int[]{5, 5})));
		assertTrue(spareFrameValidator.isValid(6, 
				TestUtil.toChancesArray(new int[]{2, 8})));
		assertTrue(spareFrameValidator.isValid(7, 
				TestUtil.toChancesArray(new int[]{0, BowlingGame.MAX_SCORE})));
	}

	@Test
	public void testValidNChances() {
		assertFalse(spareFrameValidator.isValid(8, 
				TestUtil.toChancesArray(new int[]{5, 2, 3})));
		assertFalse(spareFrameValidator.isValid(9, 
				TestUtil.toChancesArray(new int[]{1, 2, 3, 6})));
	}
}
