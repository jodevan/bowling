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
 * Represents the bowling game
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

	/**
	 * Keep track of the player info during a frame
	 */
	private Map<String, PlayTracker> playTrackerMap = new LinkedHashMap<>();
	
	/**
	 * List of players
	 */
	private List<Player> players = new ArrayList<>();

	/**
	 * Keep track of the turns of the players and when a frame ends
	 */
	private int turn = -1;
	
	/**
	 * Keep track of the current frame number
	 */
	private int frameNumber = 1;

	/**
	 * Keep track of the current game state. More info at each state class
	 */
	private BowlingState state;

	/**
	 * The possible game states
	 */
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

	/**
	 * Process each line from the input file and run each move according to
	 * the current game state
	 * @param line Line to be processed
	 * @throws PlayRecordParseException If the line is malformed
	 * @throws InvalidGameStateException If the line represents and invalid
	 * game state
	 */
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

	public StringBuilder printGame() throws InvalidGameStateException {

		StringBuilder stringBuilder = new StringBuilder();

		if (!state.equals(gameOverState)) {
			throw new InvalidGameStateException(
					"The game is not over yet. Please add more entries");
		}

		stringBuilder.append("Frame\t\t");

		IntStream.range(1, MAX_FRAMES + 1).forEach(
				i -> stringBuilder.append(String.format("%d\t\t", i)));

		this.getPlayers().forEach(player -> {
			stringBuilder.append("\n");
			stringBuilder.append(this.printPlayerGame(player.getName()));
		});

		return stringBuilder;
	}

	public StringBuilder printPlayerGame(String playerName) {

		StringBuilder stringBuilder = new StringBuilder();

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
			stringBuilder.append(player.get().getName());
			stringBuilder.append("\n");
			stringBuilder.append("Pinfalls\t");
			pinfalls.stream().forEach(stringBuilder::append);
			stringBuilder.append("\n");
			stringBuilder.append("Score\t\t");
			scores.stream().forEach(stringBuilder::append);
		}
		
		return stringBuilder; 
	}
}
