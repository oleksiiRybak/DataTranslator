package com.oleksii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DataTranslator {
	
	protected static Map<String,String> columnMap = new HashMap<>();
	protected static Map<String,String> rowMap = new HashMap<>();
	private static String tab = "\t";
	
	public static void traverseFile(String fileToBeTraversed, String outputFile) throws FileNotFoundException, IOException {
		
		Path columnsFile = Paths.get(fileToBeTraversed); 
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "utf-8"))) {
			
			parserForCustomColumnsAndRows("C:/Private/Projects/DataTranslator/RowsCustomNames.txt", rowMap);		
			
			try (BufferedReader br = Files.newBufferedReader(columnsFile)) {
			    String header = br.readLine();
			    adaptColumns(writer, header, "ColumnCustomNames.txt");
			    
			    br.lines().skip(1).forEach(line -> handleLine(writer, line));
			}			
		}		
		
	}
	
	public static void adaptColumns(Writer writer, String headers, String fileToBeParsed) throws FileNotFoundException, IOException {
		parserForCustomColumnsAndRows(fileToBeParsed, columnMap); 
		
		String[] tokens = headers.split(tab);
		writer.write(columnMap.get(tokens[0]) + tab + columnMap.get(tokens[1]) + tab + columnMap.get(tokens[3]));
	}

	protected static void parserForCustomColumnsAndRows(String fileToBeParsed, Map<String, String> customDictionary)
														throws IOException, FileNotFoundException {
		
		try (Stream<String> stream = Files.lines(Paths.get(fileToBeParsed))) {
            stream.forEach(line -> {
            	String[] tokens = line.split("\\t");				
				customDictionary.put(tokens[0] , tokens[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
	private static void handleLine(Writer writer, String line) {
		try {			
			String[] tokens = line.split(tab);
			writer.write(System.lineSeparator());
			String firstColumn = rowMap.get(tokens[0]) != null ? rowMap.get(tokens[0]) : tokens[0];
			writer.write(firstColumn + tab + tokens[1] + tab + tokens[3]);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}

}
