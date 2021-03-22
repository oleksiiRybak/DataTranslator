package com.oleksii;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataTranslatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataTranslatorApplication.class, args);
		
		try {
			DataTranslator.traverseFile("C:/Private/Projects/DataTranslator/Columns.txt", "columnOutputter.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
