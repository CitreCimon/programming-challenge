package de.exxcellent.challenge;

import java.io.InputStream;
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
		private DataBase db;
		private InputStream weatherStream;
		private InputStream footballStream;
		
		public Challenges(){
			 db = new DataBase();
			 initFileStreams();
		}
		
		private void initFileStreams(){
			weatherStream = this.getClass().getResourceAsStream("weather.csv");
			footballStream = this.getClass().getResourceAsStream("football.csv");
		}
		
		/**
		 * Solves the weather-challenge
		 * 
		 * @return day, which has the minimal difference between max and min temperature, as String 
		 */
		public String solveWeatherChallenge(){
			try {
				WeatherWrapper weatherwrapper = new WeatherWrapper(db);
				weatherwrapper.ReadDataFromCSVandStoreinOODB(weatherStream);
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
				footballwrapper.ReadDataFromCSVandStoreinOODB(footballStream);
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
