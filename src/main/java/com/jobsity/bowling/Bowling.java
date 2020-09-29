package com.jobsity.bowling;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jodevan
 */
public class Bowling {

	public static void main(String args[]) {

		String fileName = args.length > 0 ? args[0] : null;
		BowlingGame game = null;

		
		try {
			game = processGame(fileName);
			System.out.println(game.printGame());
		} catch (IOException | InvalidGameStateException 
				| PlayRecordParseException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.exit(0);
	}

	public static BowlingGame processGame(String fileName) throws IOException, 
			InvalidGameStateException, PlayRecordParseException {

		if (fileName == null) {
			throw new IOException(String.format("Usage: java %s <filepath>\n",
					Bowling.class.getCanonicalName()));
		}

		if (!new File(fileName).exists()) {
			throw new IOException(
					String.format("File not found: %s\n", fileName));
		}

		BowlingGame game = new BowlingGame();

		FileInputStream inputStream = new FileInputStream(fileName);
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNextLine()) {
			game.processPlayRecord(scanner.nextLine());
		}
		scanner.close();
		
		return game;
	}
}
