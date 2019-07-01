package de.exxcellent.challenge;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import de.exxcellent.challenge.controller.WeatherWrapper;
import de.exxcellent.challenge.exception.ExceptionChallenge;
import de.exxcellent.challenge.repository.DataBase;
import de.exxcellent.challenge.repository.Weather;

public class Tasks {
		
		//config
		final String weatherpath = "weather.csv";
		private DataBase db;
		
		
		public Tasks(){
			 db = new DataBase();	
		}
			
		/**
		 * Weather
	    In weather.csv you’ll find the daily weather data of a single month. Read the file, then output the day number (column one Day) of the day with the smallest temperature spread (difference between maximum & minimum temperature of the day.) The maximum temperature is the second column MxT, the minimum temperature the third column MnT.
		 * 
		 */
		public String solveWeatherChallenge(){
			try {
				WeatherWrapper weatherwrapper = new WeatherWrapper(db);
				weatherwrapper.ReadDataFromCSVandStoreinOODB(weatherpath);
				Function<Weather, Double> mindiffmaxmintemp = w -> w.getMxt() -  w.getMnt(); 
				
				db.getWeatherList().stream().map(mindiffmaxmintemp).forEach(System.out::println);
				Weather selectedweather = db.getWeatherList().stream().min(Comparator.comparing(mindiffmaxmintemp)).orElseThrow(NoSuchElementException::new);			    
				return String.valueOf(selectedweather.getDay());
				
			} catch (ExceptionChallenge e) {
				e.printStackTrace();
				System.exit(0);
				return null;
			}
			
		}
		
	
	
}
