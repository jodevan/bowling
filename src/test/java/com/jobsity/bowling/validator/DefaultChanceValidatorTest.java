package com.jobsity.bowling.validator;

import com.jobsity.bowling.validator.impl.DefaultFrameValidator;
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
	
	private DefaultFrameValidator defaultFrameValidator = 
			Mockito.mock(DefaultFrameValidator.class, 
					Mockito.CALLS_REAL_METHODS);
	
	@Test
	public void testInvalidFrameNumber() {
		DefaultFrameValidator mock = new DefaultFrameValidator() {
			@Override
			public boolean isValid(int[] chances) {
				return true;
			}
		};
		
		assertFalse(mock.isValid(12, new int[]{1, 2}));
	}

	@Test
	public void testNegativeChance() {
		assertFalse(defaultFrameValidator.isChanceValid(-1));
	}

	@Test
	public void testZeroChance() {
		assertTrue(defaultFrameValidator.isChanceValid(0));
	}

	@Test
	public void testChanceGreaterThanMaxFrameScore() {
		assertFalse(defaultFrameValidator.isChanceValid(Frame.MAX_SCORE + 1));
	}

	@Test
	public void testChanceGreaterThanMaxAllowed() {
		assertFalse(defaultFrameValidator.isChanceValid(10, 9));
	}

	@Test
	public void testChanceSmallerThanMaxFrameScore() {
		assertTrue(defaultFrameValidator.isChanceValid(6));
	}

	@Test
	public void testChanceSmallerThanMaxAllowed() {
		assertTrue(defaultFrameValidator.isChanceValid(6, 7));
	}
}
