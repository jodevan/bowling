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
public class SimpleFrameValidatorTest {
	
	Validator simpleFrameValidator = new SimpleFrameValidator();

	@Test
	public void testEmptyFrame() {
		assertFalse(simpleFrameValidator.isValid(null, null));
	}
}
