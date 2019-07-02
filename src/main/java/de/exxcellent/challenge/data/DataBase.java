package de.exxcellent.challenge.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to store weather and football objects as ArrayLists.
 * Has controller functions
 */

public class DataBase {
	
	private List<Weather> weather;
	private List<Football> football;
	
	public DataBase(){
		weather = new ArrayList<Weather>();
		football = new ArrayList<Football>();
	}
	
	public void addEntry(Weather weather){
		this.weather.add(weather);
	}
	
	public void addEntry(Football football){
		this.football.add(football);
	}
	
	public List<Weather> getWeatherList(){
		return weather;
	}
	
	public List<Football> getFootballList(){
		return football;
	}
}
