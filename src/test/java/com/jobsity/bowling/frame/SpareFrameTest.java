package com.jobsity.bowling.frame;

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

	@Test
	public void mock() {
		assertTrue(true);
	}

//	@Test
//	public void testCalcWithoutNextFrame() {
//		Frame spareFrame = new SpareFrame(1);
//		assertEquals(Frame.MAX_SCORE, spareFrame.calcScore());
//	}
//
//	@Test
//	public void testCalcWithNextSimpleFrame() {
//		Frame spareFrame = new SpareFrame(8);
//		spareFrame.setNextFrame(new SimpleFrame(4, 5));
//		assertEquals(14, spareFrame.calcScore());
//
//		spareFrame = new SpareFrame(8);
//		spareFrame.setNextFrame(new FinalFrame(9, 1, Frame.MAX_SCORE));
//		assertEquals(19, spareFrame.calcScore());
//
//		spareFrame = new SpareFrame(9);
//		spareFrame.setNextFrame(new FinalFrame(Frame.MAX_SCORE, 5, 2));
//		assertEquals(20, spareFrame.calcScore());
//	}
//
//	@Test
//	public void testCalcWithNextSpareFrame() {
//		Frame spareFrame = new SpareFrame(4);
//		spareFrame.setNextFrame(new SpareFrame(7));
//		assertEquals(17, spareFrame.calcScore());
//	}
//
//	@Test
//	public void testCalcWithNextStrikeFrame() {
//		Frame spareFrame = new SpareFrame(5);
//		spareFrame.setNextFrame(new StrikeFrame());
//		assertEquals(20, spareFrame.calcScore());
//	}
}
