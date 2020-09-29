package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class SpareFrameTest {

	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new SpareFrame(1, new Chance(11));
	}
	
	@Test
	public void testCalcWithoutNextFrame() {
		Frame spareFrame = new SpareFrame(1, new Chance(8));
		assertEquals(10, spareFrame.calcScore());

		spareFrame = new SpareFrame(1, new Chance(4));
		assertEquals(10, spareFrame.calcScore());
	}

	@Test
	public void testCalcWithNextSpareFrame() {
		Frame nextSpareFrame = new SpareFrame(1, new Chance(4));
		Frame spareFrame = new SpareFrame(1, nextSpareFrame, new Chance(8));
		assertEquals(14, spareFrame.calcScore());

		nextSpareFrame = new SpareFrame(1, new Chance(9));
		spareFrame = new SpareFrame(1, nextSpareFrame, new Chance(8));
		assertEquals(19, spareFrame.calcScore());
	}
	
	@Test
	public void testCalcWithNextStrikeFrame() {
		Frame nextStrikeFrame = new StrikeFrame(1);
		Frame spareFrame = new SpareFrame(1, nextStrikeFrame, new Chance(5));
		assertEquals(20, spareFrame.calcScore());
	}
	
	@Test
	public void testPrint() {
		assertEquals("0\t/", new SpareFrame(1, new Chance(0))
				.printChances());
		assertEquals("2\t/", new SpareFrame(1, new Chance(2))
				.printChances());
	}
	
}
