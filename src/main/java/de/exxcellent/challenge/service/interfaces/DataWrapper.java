package de.exxcellent.challenge.service.interfaces;

import java.io.InputStream;

import de.exxcellent.challenge.exception.ExceptionChallenge;

public interface DataWrapper {
	
	/**
	 * Method reads csv file and stores each element as object in the database.
	 * Using the {@link #mapCSVEntrytoOO} as wrapper
	 * Using the {@link #checkstructure} to proof the structure
	 */
	void ReadDataFromCSVandStoreinOODB(InputStream pathtofile) throws ExceptionChallenge ;
	/**
	 * Helper method for the {@link #ReadDataFromCSVandStoreinOODB} to map columns to object
	 */
	void mapCSVEntrytoOO(String line) throws ExceptionChallenge ;
	/**
	 * Method that proofes, if the input file has the correct structure (Comparing file header with stored header)
	 */
	void checkstructure(String line, String structure) throws ExceptionChallenge;
	/**
	 * The method checks each entry for the correct number of columns.
	 */
	void checknumberofColumns(String[] linearr, int numberofColumns) throws ExceptionChallenge;

}
