package com.jobsity.bowling.frame.calc.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.SingleFrame;
import com.jobsity.bowling.frame.SpareFrame;
import com.jobsity.bowling.frame.calc.CalcBehavior;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class SpareFrameCalcTest {

	private CalcBehavior spareFrameCalc = new SpareFrameCalc();
	private SpareFrame spareFrame;
	
	@Before
	public void init() {
		// TODO: User a builder to build instances
		spareFrame = new SpareFrame();
	}
	
	@Test
	public void calcWithEmptyFrame() {
		assertEquals(0, spareFrameCalc.calc(null));
	}

	@Test
	public void calcWithFrameAndNoChances() {
		assertEquals(0, spareFrameCalc.calc(spareFrame));
	}

	@Test
	public void calcWithFrameWithChances() {
		spareFrame.setChances(new int[]{3});
		assertEquals(10, spareFrameCalc.calc(spareFrame));
		
		Frame nextFrame = new SingleFrame();
		nextFrame.setChances(new int[]{5, 6, 7});

		spareFrame.setChances(new int[]{3});
		spareFrame.setNextFrame(nextFrame);
		assertEquals(15, spareFrameCalc.calc(spareFrame));
	}
}
