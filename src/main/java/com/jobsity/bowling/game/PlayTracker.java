package com.jobsity.bowling.game;

import com.jobsity.bowling.frame.Chance;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Keep track of the player info during a frame
 * @author jodevan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PlayTracker {
	
	private Player player;
	private List<Chance> chances = new ArrayList<>();

	public void addChance(Chance chance) {
		chances.add(chance);
	}
	
	public Chance[] getChancesArray() {
		return chances.toArray(new Chance[]{});
	}
	
	public void resetChances() {
		chances.clear();
	}
}
