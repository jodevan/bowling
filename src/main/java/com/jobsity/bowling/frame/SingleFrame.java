package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.exception.InvalidChanceException;
import com.jobsity.bowling.exception.InvalidChancesException;
import java.util.Arrays;

/**
 *
 * @author jodevan
 */
public class SingleFrame extends Frame {

	public SingleFrame() {
	}

	public SingleFrame(int chance1, int chance2) {
		if (!isChanceValid(chance1) || !isChanceValid(chance2)) {
			throw new FrameCreationException(
					new InvalidChanceException(Frame.MAX_SCORE - 1));
		}

		// The sum of chances has to be < 10. If it's 10, it should be
		// a SpareFrame instead
		if (chance1 + chance2 >= Frame.MAX_SCORE) {
			throw new FrameCreationException(
					new InvalidChancesException(Frame.MAX_SCORE - 1));
		}
		chances = new int[]{chance1, chance2};
	}

	@Override
	public int calcScore() {
		return Arrays.stream(chances)
				.reduce(0, (chance1, chance2) -> chance1 + chance2);
	}
}
