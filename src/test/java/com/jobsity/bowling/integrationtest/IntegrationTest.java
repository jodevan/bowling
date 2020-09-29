package com.jobsity.bowling.integrationtest;

import com.jobsity.bowling.Bowling;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import com.jobsity.bowling.game.state.exception.InvalidGameStateException;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class IntegrationTest {
	
	private final String expectedJobsityOutput = 
		"Frame		1		2		3		4		5		6		7		8		9		10		\n" +
		"Jeff\n" +
		"Pinfalls		X	7	/	9	0		X	0	8	8	/	F	6		X		X	X	8	1	\n" +
		"Score		20		39		48		66		74		84		90		120		148		167		\n" +
		"John\n" +
		"Pinfalls	3	/	6	3		X	8	1		X		X	9	0	7	/	4	4	X	9	0	\n" +
		"Score		16		25		44		53		82		101		110		124		132		151		";

	private final String expectedStrikesOutput = 
		"Frame		1		2		3		4		5		6		7		8		9		10		\n" +
		"John\n" +
		"Pinfalls		X		X		X		X		X		X		X		X		X	X	X	X	\n" +
		"Score		30		60		90		120		150		180		210		240		270		300		\n" +
		"Paul\n" +
		"Pinfalls		X		X		X		X		X		X		X		X		X	X	X	X	\n" +
		"Score		30		60		90		120		150		180		210		240		270		300		\n" +
		"Lucy\n" +
		"Pinfalls		X		X		X		X		X		X		X		X		X	X	X	X	\n" +
		"Score		30		60		90		120		150		180		210		240		270		300		";

	private final String expectedZeroesOutput = 
		"Frame		1		2		3		4		5		6		7		8		9		10		\n" +
		"John\n" +
		"Pinfalls	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	\n" +
		"Score		0		0		0		0		0		0		0		0		0		0		\n" +
		"Paul\n" +
		"Pinfalls	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	\n" +
		"Score		0		0		0		0		0		0		0		0		0		0		\n" +
		"Lucy\n" +
		"Pinfalls	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	\n" +
		"Score		0		0		0		0		0		0		0		0		0		0		";
	
	private final String expectedFaultsOutput = 
		"Frame		1		2		3		4		5		6		7		8		9		10		\n" +
		"John\n" +
		"Pinfalls	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	\n" +
		"Score		0		0		0		0		0		0		0		0		0		0		\n" +
		"Paul\n" +
		"Pinfalls	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	\n" +
		"Score		0		0		0		0		0		0		0		0		0		0		\n" +
		"Lucy\n" +
		"Pinfalls	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	\n" +
		"Score		0		0		0		0		0		0		0		0		0		0		";
	
	@Test(expected = IOException.class)
	public void emptyFileName() throws IOException, 
			InvalidGameStateException, PlayRecordParseException {
		Bowling.processGame(null);
	}
	
	@Test(expected = IOException.class)
	public void fileNotFound() throws IOException, 
			InvalidGameStateException, PlayRecordParseException {
		Bowling.processGame("somefile.txt");
	}

	@Test
	public void processJobsityExample() throws IOException, 
			InvalidGameStateException, PlayRecordParseException {
		System.out.println((new File(".")).getAbsolutePath());
		BowlingGame game = 
				Bowling.processGame("./src/main/resources/jobsity.txt");
		StringBuilder stringBuilder = game.printGame();
		Assert.assertEquals(expectedJobsityOutput, stringBuilder.toString());
	}

	@Test
	public void processStrikeExample() throws IOException, 
			InvalidGameStateException, PlayRecordParseException {
		System.out.println((new File(".")).getAbsolutePath());
		BowlingGame game = 
				Bowling.processGame("./src/main/resources/strikes.txt");
		StringBuilder stringBuilder = game.printGame();
		Assert.assertEquals(expectedStrikesOutput, stringBuilder.toString());
	}

	@Test
	public void processZeroesExample() throws IOException, 
			InvalidGameStateException, PlayRecordParseException {
		System.out.println((new File(".")).getAbsolutePath());
		BowlingGame game = 
				Bowling.processGame("./src/main/resources/zeroes.txt");
		StringBuilder stringBuilder = game.printGame();
		Assert.assertEquals(expectedZeroesOutput, stringBuilder.toString());
	}

	@Test
	public void processFaultsExample() throws IOException, 
			InvalidGameStateException, PlayRecordParseException {
		System.out.println((new File(".")).getAbsolutePath());
		BowlingGame game = 
				Bowling.processGame("./src/main/resources/faults.txt");
		StringBuilder stringBuilder = game.printGame();
		Assert.assertEquals(expectedFaultsOutput, stringBuilder.toString());
	}
}
