package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.StrikeFrameValidator;
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
public class StrikeFrameValidatorTest {
	
	private Validator strikeFrameValidator = new StrikeFrameValidator();

	@Test
	public void testEmptyChances() {
		assertFalse(strikeFrameValidator.isValid(1, new int[]{}));
	}

	@Test
	public void testInvalid1Chance() {
		assertFalse(strikeFrameValidator.isValid(2, new int[]{4}));
	}

	@Test
	public void testValid1Chance() {
		assertTrue(strikeFrameValidator.isValid(3, new int[]{Frame.MAX_SCORE}));
	}

	public void testValidNChances() {
		assertFalse(strikeFrameValidator.isValid(4, new int[]{6, 4}));
		assertFalse(strikeFrameValidator.isValid(5, new int[]{5, 2, 3}));
	}
}
