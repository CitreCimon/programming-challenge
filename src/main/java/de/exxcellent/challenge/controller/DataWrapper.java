package de.exxcellent.challenge.controller;

public interface DataWrapper {

	void ReadDataFromCSVandStoreinOODB(String pathtofile) throws ExceptionChallenge ;
	void mapCSVEntrytoOO(String line) throws ExceptionChallenge ;
	void checkstructure(String line, String structure) throws ExceptionChallenge;
	void checknumberofColumns(String[] linearr, int numberofColumns) throws ExceptionChallenge;

}
