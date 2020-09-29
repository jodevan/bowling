package com.jobsity.bowling;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 *
 * @author jodevan
 */
public class Bowling {

	public static void main(String args[]) {
		if (args.length == 0) {
			System.out.printf("Usage: java %s <filepath>\n",
					Bowling.class.getCanonicalName());
			System.exit(0);
		}

		String fileName = args[0];

		if (!new File(fileName).exists()) {
			System.out.printf("File not found: %s\n", fileName);
			System.exit(1);
		}
		
		BowlingGame game = new BowlingGame();

		AtomicInteger lineNumber = new AtomicInteger(0);

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(line -> {
				try {
					lineNumber.incrementAndGet();
					game.processPlayRecord(line);
				} catch (PlayRecordParseException 
						| InvalidGameStateException e) {
					System.out.printf("Error when processing line %d: %s\n", 
							lineNumber.get(), line);
					e.printStackTrace();
					System.exit(1);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			game.printGame();
		} catch (InvalidGameStateException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.exit(0);
	}
}
