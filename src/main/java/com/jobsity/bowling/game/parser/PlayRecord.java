package com.jobsity.bowling.game.parser;

import com.jobsity.bowling.frame.Chance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Once a line is read, it's converted to a PlayRecord that stores the read
 * player name and chance
 * @author jodevan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PlayRecord {
	
	private String player;
	private Chance chance;
}
