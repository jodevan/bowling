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
public class ThreeChancesFrameValidatorTest {
	
	Validator threeChancesFrameValidator = new ThreeChancesFrameValidator();

	@Test
	public void testEmptyFrame() {
		assertFalse(threeChancesFrameValidator.isValid(null, null));
	}
}
