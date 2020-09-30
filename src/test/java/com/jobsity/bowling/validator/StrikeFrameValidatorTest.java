package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.StrikeFrameValidator;
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
public class StrikeFrameValidatorTest {
	
	private ValidatorBehavior strikeFrameValidator = new StrikeFrameValidator();

	@Test
	public void testEmptyChances() {
		assertFalse(strikeFrameValidator.isValid(1, 
				TestUtil.toChancesArray(new int[]{})));
	}

	@Test
	public void testInvalid1Chance() {
		assertFalse(strikeFrameValidator.isValid(2, 
				TestUtil.toChancesArray(new int[]{4})));
	}

	@Test
	public void testValid1Chance() {
		assertTrue(strikeFrameValidator.isValid(
				3, TestUtil.toChancesArray(new int[]{BowlingGame.MAX_SCORE})));
	}

	public void testValidNChances() {
		assertFalse(strikeFrameValidator.isValid(4, 
				TestUtil.toChancesArray(new int[]{6, 4})));
		assertFalse(strikeFrameValidator.isValid(5, 
				TestUtil.toChancesArray(new int[]{5, 2, 3})));
	}
}
