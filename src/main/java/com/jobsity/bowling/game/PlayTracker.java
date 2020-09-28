package com.jobsity.bowling.game;

import com.jobsity.bowling.player.Player;
import java.util.ArrayList;
import java.util.List;
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
public class PlayTracker {
	
	private Player player;
	private List<Integer> chances = new ArrayList<>();

	public void addChance(Integer chance) {
		chances.add(chance);
	}
	
	public int[] getChancesArray() {
		return chances.stream().mapToInt(i -> i).toArray();
	}
	
	public int sumChances() {
		return chances.stream().reduce(0, (c1, c2) -> c1 + c2);
	}
	
	public void resetChances() {
		chances.clear();
	}
}
