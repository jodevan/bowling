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
	
	public boolean isChanceValid(int chance) {
		return isChanceValid(chance, Frame.MAX_SCORE);
	}

	public boolean isChanceValid(int chance, int maxChanceAllowedValue) {
		return chance >= 0 && chance <= maxChanceAllowedValue;
	}
	
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
