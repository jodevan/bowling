package com.jobsity.bowling;

import com.jobsity.bowling.game.parser.PlayRecordParser;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(line -> {
				try {
					System.out.println(PlayRecordParser.parsePlayRecord(line).toString());
				} catch (PlayRecordParseException e) {
					e.printStackTrace();
					System.exit(1);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}
}
