package com.jobsity.bowling.frame;

import static org.junit.Assert.*;

import com.jobsity.bowling.frame.exception.FrameCreationException;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class SimpleFrameTest {
	
	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new SimpleFrame(1, new Chance(11), new Chance(5));
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new SimpleFrame(1, new Chance(0), new Chance(-10));
	}

	@Test(expected = FrameCreationException.class)
	public void expectSumChancesValuesInvalid() {
		new SimpleFrame(1, new Chance(5), new Chance(6));
	}

	@Test(expected = Test.None.class)
	public void testValidFrame() {
		new SimpleFrame(1, new Chance(5), new Chance(4));
	}
	
	@Test
	public void testCalcScore() {
		assertEquals(0, new SimpleFrame(1, new Chance(0), new Chance(0))
				.calcScore());
		assertEquals(9, new SimpleFrame(1, new Chance(2), new Chance(7))
				.calcScore());
		assertEquals(8, new SimpleFrame(1, new Chance(5), new Chance(3))
				.calcScore());
	}
	
	@Test
	public void testPrint() {
		assertEquals("0\t0", 
				new SimpleFrame(1, new Chance(0), new Chance(0))
						.printChances());
		assertEquals("2\t7", 
				new SimpleFrame(1, new Chance(2), new Chance(7))
						.printChances());
	}
}
