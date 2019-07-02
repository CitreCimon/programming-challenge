package de.exxcellent.challenge;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import de.exxcellent.challenge.data.DataBase;
import de.exxcellent.challenge.data.Football;
import de.exxcellent.challenge.data.Weather;
import de.exxcellent.challenge.exception.ExceptionChallenge;
import de.exxcellent.challenge.service.impl.FootballWrapper;
import de.exxcellent.challenge.service.impl.WeatherWrapper;

/**
 * The class to solve the particular challanges
 * 
 */
public class Challenges {
		
		//config
		private String weatherpath = "de/exxcellent/challenge/weather.csv";
		private String footballpath = "de/exxcellent/challenge/football.csv";
		private DataBase db;
		
		
		public Challenges(){
			 db = new DataBase();	
		}
			
		/**
		 * Solves the weather-challenge
		 * 
		 * @return day, which has the minimal difference between max and min temperature, as String 
		 */
		public String solveWeatherChallenge(){
			try {
				WeatherWrapper weatherwrapper = new WeatherWrapper(db);
				weatherwrapper.ReadDataFromCSVandStoreinOODB(weatherpath);
				Function<Weather, Double> mindiffmaxmintemp = w -> w.getMxt() -  w.getMnt(); 
				
				Weather selectedweather = db.getWeatherList().stream().min(Comparator.comparing(mindiffmaxmintemp)).orElseThrow(NoSuchElementException::new);			    
				return String.valueOf(selectedweather.getDay());
				
			} catch (ExceptionChallenge e) {
				e.printStackTrace();
				System.exit(0);
				return null;
			}			
		}
		
		/**
		 * Solves the football-challenge
		 * 
		 * @return team, which has the minimal absolute difference between goals and goals allowed, as String 
		 */
		public String solveFootballChallenge(){
			try {
				FootballWrapper footballwrapper = new FootballWrapper(db);
				footballwrapper.ReadDataFromCSVandStoreinOODB(footballpath);
				Function<Football, Integer> goalvsalloweddiff = f -> Math.abs(f.getGoals() -f.getGoals_allowed()); 
				Football selectedfootball = db.getFootballList().stream().min(Comparator.comparing(goalvsalloweddiff)).orElseThrow(NoSuchElementException::new);			    
				return String.valueOf(selectedfootball.getTeam());
			} catch (ExceptionChallenge e) {
				e.printStackTrace();
				System.exit(0);
				return null;
			}
			
		}
		
		
	
	
}
