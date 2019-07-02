package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.data.DataBase;
import de.exxcellent.challenge.data.Weather;
import de.exxcellent.challenge.exception.ExceptionChallenge;

public class WeatherWrapper extends FileWrapper{
	
	private DataBase db;
	
	public WeatherWrapper(DataBase db){
		super();
		this.db = db;
	}
	
	public void mapCSVEntrytoOO(String line) throws ExceptionChallenge{
		
		String[] linearr = line.split(Weather.getSeperator());
		checknumberofColumns(linearr, Weather.getNumberofColumns());
		Weather weather = new Weather();
		weather.setDay(Integer.parseInt((linearr[0])));
		weather.setMxt(Integer.parseInt(linearr[1]));
		weather.setMnt(Integer.parseInt(linearr[2]));
		weather.setAvt(Integer.parseInt(linearr[3]));
		weather.setAvdp(Double.parseDouble(linearr[4]));
		weather.setHrptpcpn(Integer.parseInt(linearr[5]));
		weather.setPdir(Integer.parseInt(linearr[6]));
		weather.setAvsp(Double.parseDouble(linearr[7]));
		weather.setDir(Integer.parseInt(linearr[8]));
		weather.setMxs(Integer.parseInt(linearr[9]));
		weather.setSkyc(Double.parseDouble(linearr[10]));
		weather.setMxr(Integer.parseInt(linearr[11]));
		weather.setMn(Integer.parseInt(linearr[12])); 
		weather.setRavslp(Double.parseDouble(linearr[13]));
		db.addEntry(weather);	
	}
	
	public void checkstructure(String line, String structure) throws ExceptionChallenge {
		super.checkstructure(line, Weather.getStructure());
	}
	
	public void checknumberofColumns(String[] linearr, int numberofColumns) throws ExceptionChallenge {
		super.checknumberofColumns(linearr, Weather.getNumberofColumns());
	}
}
