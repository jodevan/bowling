package com.jobsity.bowling.frame;

import static org.junit.Assert.*;
import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.game.BowlingGame;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class FinalFrameTest {
	
	// FinalFrame extends SingleFrame, hence the tests run for SimpleFrame
	// are also valid for FinalFrame
	
	@Test(expected = FrameCreationException.class)
	public void expectFirstChanceInvalid() {
		new FinalFrame(1, new Chance(11), new Chance(5), new Chance(4));
	}

	@Test(expected = FrameCreationException.class)
	public void expectSecondChanceInvalid() {
		new FinalFrame(1, new Chance(10), new Chance(-2), new Chance(4));
	}

	@Test(expected = FrameCreationException.class)
	public void expectThirdChanceInvalid() {
		new FinalFrame(1, new Chance(10), new Chance(0), new Chance(14));
	}

	@Test(expected = FrameCreationException.class)
	public void expectThirdChanceNotAcceptable() {
		new FinalFrame(1, new Chance(4), new Chance(5), new Chance(6));
	}

	@Test(expected = Test.None.class)
	public void expectThirdChanceAcceptable() {
		// A spare
		new FinalFrame(1, new Chance(2), new Chance(8), new Chance(6));

		// A strike
		new FinalFrame(1, new Chance(BowlingGame.MAX_SCORE), 
				new Chance(8), new Chance(2));

		// 2 strikes
		new FinalFrame(1, new Chance(BowlingGame.MAX_SCORE), 
				new Chance(BowlingGame.MAX_SCORE), new Chance(9));
	}

	@Test
	public void testCalc() {
		Frame finalFrame = new FinalFrame(1, new Chance(1), new Chance(5));
		assertEquals(6, finalFrame.calcScore());

		finalFrame = new FinalFrame(1, new Chance(0), new Chance(8));
		assertEquals(8, finalFrame.calcScore());

		finalFrame = new FinalFrame(1, new Chance(BowlingGame.MAX_SCORE), 
				new Chance(9), new Chance(1));
		assertEquals(20, finalFrame.calcScore());
	}
	
	@Test
	public void testPrint() {
		assertEquals("1\t5", new FinalFrame(1, 
				new Chance(1), new Chance(5)).printChances());
		assertEquals("X\t9\t1", new FinalFrame(
				1, new Chance(BowlingGame.MAX_SCORE), new Chance(9), 
				new Chance(1)).printChances());
		assertEquals("X\tX\tX", new FinalFrame(
				1, new Chance(BowlingGame.MAX_SCORE), 
				new Chance(BowlingGame.MAX_SCORE), 
				new Chance(BowlingGame.MAX_SCORE)).printChances());
	}
	
}
