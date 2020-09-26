package com.jobsity.bowling.frame;

/**
 *
 * @author jodevan
 */
public abstract class Frame {

	public static final int MAX_SCORE = 10;

	protected int[] chances = new int[]{};
	protected Frame nextFrame;

	public abstract int calcScore();

	public int[] getChances() {
		return chances;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}

	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}
}
