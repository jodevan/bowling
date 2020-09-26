package com.jobsity.bowling.validator;

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
	
	Validator spareFrameValidator = new SpareFrameValidator();

	@Test
	public void testEmptyFrame() {
		assertFalse(spareFrameValidator.isValid(null, null));
	}
}
