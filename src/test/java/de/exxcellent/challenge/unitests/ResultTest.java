package de.exxcellent.challenge.unitests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


import de.exxcellent.challenge.Challenges;

public class ResultTest {

	@Test
	public void testWeatherResult(){
		Challenges testchallanges = new Challenges();
		assertEquals("14", testchallanges.solveWeatherChallenge());
	}
	
	@Test
	public void testFootballResult(){
		Challenges testchallanges = new Challenges();
		assertEquals("Aston_Villa", testchallanges.solveFootballChallenge());
	}
}
