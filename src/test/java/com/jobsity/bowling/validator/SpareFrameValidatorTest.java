package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.SpareFrameValidator;
import com.jobsity.bowling.game.BowlingGame;
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
		assertFalse(spareFrameValidator.isValid(1, new int[]{}));
	}
	
	@Test
	public void testInvalid2Chances() {
		assertFalse(spareFrameValidator.isValid(2, new int[]{-1, 3}));
		assertFalse(spareFrameValidator.isValid(3, new int[]{5, 4}));
		assertFalse(spareFrameValidator.isValid(4, new int[]{11, 0}));
	}

	@Test
	public void testValid2Chances() {
		assertTrue(spareFrameValidator.isValid(5, new int[]{5, 5}));
		assertTrue(spareFrameValidator.isValid(6, new int[]{2, 8}));
		assertTrue(spareFrameValidator.isValid(7, 
				new int[]{0, BowlingGame.MAX_SCORE}));
	}

	@Test
	public void testValidNChances() {
		assertFalse(spareFrameValidator.isValid(8, new int[]{5, 2, 3}));
		assertFalse(spareFrameValidator.isValid(9, new int[]{1, 2, 3, 6}));
	}
}
