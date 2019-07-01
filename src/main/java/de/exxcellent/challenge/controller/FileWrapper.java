package de.exxcellent.challenge.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.exxcellent.challenge.exception.ExceptionChallenge;
import de.exxcellent.challenge.repository.Weather;

public abstract class FileWrapper implements DataWrapper{
	
	private ClassLoader classLoader;
	
	public FileWrapper(){
		classLoader = ClassLoader.getSystemClassLoader();
	}

	@Override
	public void ReadDataFromCSVandStoreinOODB(String pathtofile) throws ExceptionChallenge  {		
		try {
			InputStream inputStream = classLoader.getResourceAsStream(pathtofile);
			if  (null == inputStream){
				throw new ExceptionChallenge("Resource: " + pathtofile + " is not available.");
			}
			BufferedReader javaFileReader =  new BufferedReader(new InputStreamReader(inputStream));
			String line = javaFileReader.readLine();
			checkstructure(line, Weather.getStructure() );
			while (line != null) {
				line = javaFileReader.readLine();
				if (line != null){
					mapCSVEntrytoOO(line);
				}
			}
		} catch (IOException e) {
			throw new ExceptionChallenge("Could not read " + pathtofile + " File.");
		}
		
	}

	public void mapCSVEntrytoOO(String line) throws ExceptionChallenge {		
	}
	
	public void checkstructure(String line, String structure) throws ExceptionChallenge {
		if (line.equals(null)){
			throw new ExceptionChallenge("There is no header defined.");
		}
		if (!line.equals(structure)){
			throw new ExceptionChallenge("Structure mismatch.");
		}
	}
	
	public void checknumberofColumns(String[] linearr, int numberofColumns) throws ExceptionChallenge {
		if (linearr.length != numberofColumns){
			throw new ExceptionChallenge("File has a wrong number of columns");
		}
		
	}

	
}
