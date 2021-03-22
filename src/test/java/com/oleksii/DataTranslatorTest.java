package com.oleksii;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataTranslatorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTraverseFile() {
		//fail("Not yet implemented");
	}

	@Test
	void testAdaptColumns() throws FileNotFoundException, IOException {
		Writer testWriter = new TestWriter();
		String headers = "COL0	COL1	COL2	COL3";
		String fileToBeParsed = "CustColumnNames.txt";

		DataTranslator.adaptColumns(testWriter, headers, fileToBeParsed);
		
		assertTrue(testWriter.toString() != null);	
		assertTrue(testWriter.toString().contains("CUST_COL0"));
		assertTrue(testWriter.toString().contains("CUST_COL1"));
		assertTrue(testWriter.toString().contains("CUST_COL3"));
	}

	@Test
	void testParserForCustomColumnsAndRows() {
		//fail("Not yet implemented");
	}

}
