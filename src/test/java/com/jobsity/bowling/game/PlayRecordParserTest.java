package com.jobsity.bowling.game;

import com.jobsity.bowling.game.parser.PlayRecordParser;
import com.jobsity.bowling.game.parser.PlayRecord;
import static org.junit.Assert.*;

import com.jobsity.bowling.game.parser.exception.PlayRecordParseException;
import org.junit.Test;

import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author jodevan
 */
@RunWith(JUnit4ClassRunner.class)
public class PlayRecordParserTest {
	
	@Test(expected = PlayRecordParseException.class)
	public void testNullLine() throws PlayRecordParseException {
		PlayRecordParser.parsePlayRecord(null);
	}

	@Test(expected = PlayRecordParseException.class)
	public void testEmptyLine() throws PlayRecordParseException {
		PlayRecordParser.parsePlayRecord(new String());
	}

	@Test(expected = PlayRecordParseException.class)
	public void testLineWithOnlySpaces() throws PlayRecordParseException {
		PlayRecordParser.parsePlayRecord(new String("   \t "));
	}

	@Test(expected = PlayRecordParseException.class)
	public void testLineWithOnlyPlayerName() throws PlayRecordParseException {
		PlayRecordParser.parsePlayRecord(new String("John"));
	}

	@Test(expected = PlayRecordParseException.class)
	public void testLineWithPlayerNameAndWrongNumberOfTabs() 
			throws PlayRecordParseException {
		PlayRecordParser.parsePlayRecord(new String("John\t\t10"));
	}

	@Test(expected = Test.None.class)
	public void testValidInputs() 
			throws PlayRecordParseException {
		PlayRecord playRecord;
		
		playRecord = PlayRecordParser.parsePlayRecord(new String("John\t10"));
		assertEquals("John", playRecord.getPlayer());
		assertEquals(10, playRecord.getChance());

		playRecord = PlayRecordParser.parsePlayRecord(new String("Mary\t0"));
		assertEquals("Mary", playRecord.getPlayer());
		assertEquals(0, playRecord.getChance());

		playRecord = PlayRecordParser.parsePlayRecord(new String("Paul\tF"));
		assertEquals("Paul", playRecord.getPlayer());
		assertEquals(0, playRecord.getChance());
	}
}
