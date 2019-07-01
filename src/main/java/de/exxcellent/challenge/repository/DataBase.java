package de.exxcellent.challenge.repository;

import java.util.ArrayList;
import java.util.List;

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
