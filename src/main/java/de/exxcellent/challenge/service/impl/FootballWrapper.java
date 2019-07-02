package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.data.DataBase;
import de.exxcellent.challenge.data.Football;
import de.exxcellent.challenge.exception.ExceptionChallenge;

public class FootballWrapper extends FileWrapper {
	
	private DataBase db;
	
	public FootballWrapper(DataBase db){
		super();
		this.db = db;
	}
	
	@Override
	public void mapCSVEntrytoOO(String line) throws ExceptionChallenge{
		String[] linearr = line.split(Football.getSeperator());
		super.checknumberofColumns(linearr, Football.getNumberofColumns());
		Football football = new Football();
		football.setTeam(linearr[0]);
		football.setGames(Integer.parseInt(linearr[1]));
		football.setWins(Integer.parseInt(linearr[2]));
		football.setLosses(Integer.parseInt(linearr[3]));
		football.setDraws(Integer.parseInt(linearr[4]));
		football.setGoals(Integer.parseInt(linearr[5]));
		football.setGoals_allowed(Integer.parseInt(linearr[6]));
		football.setPoints(Integer.parseInt(linearr[7]));
		db.addEntry(football);
	}
	
	
	public void checkstructure(String line, String structure) throws ExceptionChallenge {
		super.checkstructure(line, Football.getStructure());
	}
	
	public void checknumberofColumns(String[] linearr, int numberofColumns) throws ExceptionChallenge {
		super.checknumberofColumns(linearr, Football.getNumberofColumns());
	}
	
}
