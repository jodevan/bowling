package com.jobsity.bowling.validator;

import static org.junit.Assert.*;

import com.jobsity.bowling.frame.Frame;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class DefaultChanceValidatorTest {
	
	private DefaultChanceValidator defaultChanceValidator = 
			Mockito.mock(DefaultChanceValidator.class, 
					Mockito.CALLS_REAL_METHODS);
	
	@Test
	public void testNegativeChance() {
		assertFalse(defaultChanceValidator.isChanceValid(-1));
	}

	@Test
	public void testZeroChance() {
		assertTrue(defaultChanceValidator.isChanceValid(0));
	}

	@Test
	public void testChanceGreaterThanMaxFrameScore() {
		assertFalse(defaultChanceValidator.isChanceValid(Frame.MAX_SCORE + 1));
	}

	@Test
	public void testChanceGreaterThanMaxAllowed() {
		assertFalse(defaultChanceValidator.isChanceValid(10, 9));
	}

	@Test
	public void testChanceSmallerThanMaxFrameScore() {
		assertTrue(defaultChanceValidator.isChanceValid(6));
	}

	@Test
	public void testChanceSmallerThanMaxAllowed() {
		assertTrue(defaultChanceValidator.isChanceValid(6, 7));
	}
}
