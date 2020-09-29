package com.jobsity.bowling.util;

import com.jobsity.bowling.frame.Chance;
import java.util.Arrays;

/**
 *
 * @author jodevan
 */
public class TestUtil {
	
	public static Chance[] toChancesArray(int... chances) {
		if (chances == null) {
			return null;
		}
		return Arrays.stream(chances).mapToObj(
				chance -> new Chance(chance)).toArray(Chance[]::new);
	}

}
