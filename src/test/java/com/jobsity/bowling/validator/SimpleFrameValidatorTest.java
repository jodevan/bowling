package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.SimpleFrameValidator;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class SimpleFrameValidatorTest {
	
	private Validator simpleFrameValidator = new SimpleFrameValidator();

	@Test
	public void testEmptyChances() {
		assertFalse(simpleFrameValidator.isValid(1, new int[]{}));
	}

	@Test
	public void testInvalidChances() {
		assertFalse(simpleFrameValidator.isValid(2, new int[]{4, 6}));
	}

	@Test
	public void testValidChances() {
		assertTrue(simpleFrameValidator.isValid(3, new int[]{4, 4}));
	}
	
	@Test
	public void testInvalid2Chances() {
		assertFalse(simpleFrameValidator.isValid(4, new int[]{-1, 3}));
		assertFalse(simpleFrameValidator.isValid(5, new int[]{5, 5}));
		assertFalse(simpleFrameValidator.isValid(6, new int[]{7, 12}));
	}

	@Test
	public void testValid2Chances() {
		assertTrue(simpleFrameValidator.isValid(7, new int[]{1, 5}));
		assertTrue(simpleFrameValidator.isValid(8, new int[]{0, 8}));
		assertTrue(simpleFrameValidator.isValid(9, new int[]{4, 1}));
	}

	@Test
	public void testValidNChances() {
		assertFalse(simpleFrameValidator.isValid(1, new int[]{1}));
		assertFalse(simpleFrameValidator.isValid(2, new int[]{1, 2, 3}));
		assertFalse(simpleFrameValidator.isValid(3, new int[]{1, 2, 3, 4}));
	}	
}
