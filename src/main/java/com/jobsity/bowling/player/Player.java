package com.jobsity.bowling.player;

import com.jobsity.bowling.frame.Frame;
import lombok.Builder;
import lombok.Data;

/**
 * Represents a player
 *
 * @author jodevan
 */
@Data
@Builder
public class Player {

	private String name;
	private Frame frame;
}
