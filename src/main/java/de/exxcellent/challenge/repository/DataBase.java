package de.exxcellent.challenge.repository;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

	private List<Weather> weather;
	
	public DataBase(){
		weather = new ArrayList<Weather>();
	}
	
	
	public void addEntry(Weather weather){
		this.weather.add(weather);
	}
		
	
	public List<Weather> getWeatherList(){
		return weather;
	}
	

}
