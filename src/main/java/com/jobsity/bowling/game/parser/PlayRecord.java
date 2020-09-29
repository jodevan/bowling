package com.jobsity.bowling.game.parser;

import com.jobsity.bowling.frame.Chance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
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
