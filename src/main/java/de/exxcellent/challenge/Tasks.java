package de.exxcellent.challenge;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Function;

import de.exxcellent.challenge.controller.FootballWrapper;
import de.exxcellent.challenge.controller.WeatherWrapper;
import de.exxcellent.challenge.exception.ExceptionChallenge;
import de.exxcellent.challenge.repository.DataBase;
import de.exxcellent.challenge.repository.Football;
import de.exxcellent.challenge.repository.Weather;

public class Tasks {
		
		//config
		final String weatherpath = "de/exxcellent/challenge/weather.csv";
		final String footballpath = "de/exxcellent/challenge/football.csv";
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
				
				Weather selectedweather = db.getWeatherList().stream().min(Comparator.comparing(mindiffmaxmintemp)).orElseThrow(NoSuchElementException::new);			    
				return String.valueOf(selectedweather.getDay());
				
			} catch (ExceptionChallenge e) {
				e.printStackTrace();
				System.exit(0);
				return null;
			}
			
		}
		
		/**
		 * 
		Football
	    The football.csv file contains results of the English Premier League. The columns labeled ‘Goals’ and ‘Goals Allowed’ contain the total number of goals scored by and against each team (so Arsenal scored 79 goals themselves and had 36 goals scored against them). Read the file, then print the name of the team with the smallest distance (absolute difference) between ‘Goals’ and ‘Goals Allowed’.
		* 
		 */
		public String solveFootballChallenge(){
			try {
				FootballWrapper footballwrapper = new FootballWrapper(db);
				footballwrapper.ReadDataFromCSVandStoreinOODB(footballpath);
				Function<Football, Integer> goalvsalloweddiff = f -> Math.abs(f.getGoals() -f.getGoals_allowed()); 
				
				db.getFootballList().stream().map(goalvsalloweddiff).forEach(System.out::println);
				Football selectedfootball = db.getFootballList().stream().min(Comparator.comparing(goalvsalloweddiff)).orElseThrow(NoSuchElementException::new);			    
				return String.valueOf(selectedfootball.getTeam());
			} catch (ExceptionChallenge e) {
				e.printStackTrace();
				System.exit(0);
				return null;
			}
			
		}
		
		
	
	
}
