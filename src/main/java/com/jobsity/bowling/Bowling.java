package com.jobsity.bowling;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Runnable class
 * @author jodevan
 */
public class Bowling {

	public static void main(String args[]) {

		String filePath = args.length > 0 ? args[0] : null;
		BowlingGame game = null;

		try {
			game = processGame(filePath);
			System.out.println(game.printGame());
		} catch (IOException | InvalidGameStateException 
				| PlayRecordParseException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.exit(0);
	}

	/**
	 * Process the passed filename and returns an instance of the game
	 * @param filePath File path to be processed 
	 * @return An object that represents the game described in the file
	 * @throws IOException If the file can't be found
	 * @throws InvalidGameStateException If the moves described in the file
	 * corresponds to an invalid game
	 * @throws PlayRecordParseException If the data in the file are invalid 
	 */
	public static BowlingGame processGame(String filePath) throws IOException, 
			InvalidGameStateException, PlayRecordParseException {

		if (filePath == null) {
			throw new IOException(String.format("Usage: java %s <filepath>\n",
					Bowling.class.getCanonicalName()));
		}

		if (!new File(filePath).exists()) {
			throw new IOException(
					String.format("File not found: %s\n", filePath));
		}

		BowlingGame game = new BowlingGame();

		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) {
			game.processPlayRecord(scanner.nextLine());
		}
		scanner.close();
		
		return game;
	}
}
