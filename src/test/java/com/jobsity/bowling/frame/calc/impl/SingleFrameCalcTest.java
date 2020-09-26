package com.jobsity.bowling.frame.calc.impl;

import com.jobsity.bowling.frame.SingleFrame;
import static org.junit.Assert.*;

import com.jobsity.bowling.frame.calc.CalcBehavior;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class SingleFrameCalcTest {
	
	private CalcBehavior singleFrameCalc = new SingleFrameCalc();
	private SingleFrame singleFrame;
	
	@Before
	public void init() {
		// TODO: User a builder to build instances
		singleFrame = new SingleFrame();
	}
	
	@Test
	public void calcWithEmptyFrame() {
		assertEquals(0, singleFrameCalc.calc(null));
	}

	@Test
	public void calcWithFrameAndNoChances() {
		assertEquals(0, singleFrameCalc.calc(singleFrame));
	}

	@Test
	public void calcWithFrameWithChances() {
		singleFrame.setChances(new int[]{3});
		assertEquals(3, singleFrameCalc.calc(singleFrame));

		singleFrame.setChances(new int[]{3, 6});
		assertEquals(9, singleFrameCalc.calc(singleFrame));

		singleFrame.setChances(new int[]{10, 6, 9});
		assertEquals(25, singleFrameCalc.calc(singleFrame));
	}
}
