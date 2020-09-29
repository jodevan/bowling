package com.jobsity.bowling.game;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.game.parser.PlayRecordParser;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import com.jobsity.bowling.game.state.BowlingState;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import com.jobsity.bowling.game.state.impl.FinalFrameFirstChanceState;
import com.jobsity.bowling.game.state.impl.FinalFrameSecondChanceState;
import com.jobsity.bowling.game.state.impl.FinalFrameThirdChanceState;
import com.jobsity.bowling.game.state.impl.GameOverState;
import com.jobsity.bowling.game.state.impl.InitialFrameFirstChanceState;
import com.jobsity.bowling.game.state.impl.InitialFrameSecondChanceState;
import com.jobsity.bowling.game.state.impl.RegularFrameFirstChanceState;
import com.jobsity.bowling.game.state.impl.RegularFrameSecondChanceState;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jodevan
 */
@Getter
@Setter
public class BowlingGame {

	/**
	 * Constant to represent the max number of frames
	 */
	public static final int MAX_FRAMES = 10;
	/**
	 * Constant to represent the max allowed score for a chance
	 */
	public static final int MAX_SCORE = 10;
	
	public static final int FAULT_INT_VALUE = -1;

	private Map<String, PlayTracker> playTrackerMap = new LinkedHashMap<>();
	private List<Player> players = new ArrayList<>();

	private int turn = -1;
	private int frameNumber = 1;
	
	private BowlingState state;
	
	private final BowlingState initialFrameFirstChanceState;
	private final BowlingState initialFrameSecondChanceState;
	private final BowlingState regularFrameFirstChanceState;
	private final BowlingState regularFrameSecondChanceState;
	private final BowlingState finalFrameFirstChanceState;
	private final BowlingState finalFrameSecondChanceState;
	private final BowlingState finalFrameThirdChanceState;
	private final BowlingState gameOverState;

	public BowlingGame() {
		initialFrameFirstChanceState = new InitialFrameFirstChanceState(this);
		initialFrameSecondChanceState = new InitialFrameSecondChanceState(this);
		regularFrameFirstChanceState = new RegularFrameFirstChanceState(this);
		regularFrameSecondChanceState = new RegularFrameSecondChanceState(this);
		finalFrameFirstChanceState = new FinalFrameFirstChanceState(this);
		finalFrameSecondChanceState = new FinalFrameSecondChanceState(this);
		finalFrameThirdChanceState = new FinalFrameThirdChanceState(this);
		gameOverState = new GameOverState(this);
		state = initialFrameFirstChanceState;
	}
	
	public void processPlayRecord(String line) 
			throws PlayRecordParseException, InvalidGameStateException {
		state.play(PlayRecordParser.parsePlayRecord(line));
	}
	
	public void addPlayer(Player player) {
		if (player != null) {
			players.add(player);
		}
	}
	
	public Player getTurnPlayer() {
		if (!playTrackerMap.isEmpty()) {
			return players.get(turn);
		}
		return null;
	}
	
	public void incrementTurn() {
		turn = ++turn % players.size();
	}
	
	public void endTurn() {
		turn++;
		if (turn == players.size()) {
			turn = 0;
			frameNumber++;
		}
	}
	
	public void printGame() {
		System.out.print("Frame\t\t");

		IntStream.range(1, MAX_FRAMES + 1).forEach(
				i -> System.out.printf("%d\t\t", i));
		System.out.println();

		this.getPlayers().forEach(player -> {
			this.printPlayerGame(player.getName());
		});
	}

	public void printPlayerGame(String playerName) {
		List<String> pinfalls = new ArrayList<>();
		List<String> scores = new ArrayList<>();
		
		Optional<Player> player = players.stream()
				.filter(p -> p.getName().equals(playerName)).findFirst();
		
		if (player.isPresent()) {
			Frame f = player.get().getFrame();
			int score = 0;
			while (f != null) {
				pinfalls.add(String.format("%s\t", f.printChances()));
				score += f.calcScore();
				scores.add(String.format("%d\t\t", score));
				f = f.getNextFrame();
			}
			System.out.println(player.get().getName());
			System.out.print("Pinfalls\t");
			pinfalls.stream().forEach(System.out::print);
			System.out.println();
			System.out.print("Score\t\t");
			scores.stream().forEach(System.out::print);
			System.out.println();
		}

	}
}
