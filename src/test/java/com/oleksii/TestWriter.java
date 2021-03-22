package com.oleksii;

import java.io.IOException;
import java.io.Writer;

public class TestWriter extends Writer {
	
	private StringBuilder stringBuilder = new StringBuilder();
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() throws IOException {		
	}

	@Override
	public void write(String str) {
		stringBuilder.append(str);
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return this.stringBuilder.toString();
		
	}
	
}
