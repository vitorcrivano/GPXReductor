package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import MathLogic.MathCalcultaorOfDistance;

public class CalculatorTest {

	@Test
	//Test the Orthogonal Slope
	public void OrthogonalSlopeTest() {
		
		double result = MathCalcultaorOfDistance.calculateOrthogonalSlope(2);
		double expectedResult = -1/2;
			
		//delta as 0.7
	    assertEquals(result, expectedResult, 0.7); 	
	}

	@Test
	//Test the YIntercept function
	public void YInterceptTest() {
		double result = MathCalcultaorOfDistance.calculateYIntercept(2, 3, 10);
		double expectedResult = 4.0;
			
		//delta as 0.7
	    assertEquals(result, expectedResult, 0.); 		
	}

	@Test
	//Test the Haversine Function
	public void HaversineTest() {
		
		//According to http://rosettacode.org/wiki/Haversine_formula#Java
		double h = MathCalcultaorOfDistance.haversine(42.049785, -71.265993, 42.049806, -71.266229);
		double hResult = 0.019631296425057555;
		
		//Testing with the delta as 1
        assertEquals(h, hResult, 1); 	
	}
        
	@Test
	//Test the Slope Function
	public void SlopeTest() {
		
		double result = MathCalcultaorOfDistance.calculateSlope(6, 10, 4, 2);
		double expectedResult = 0.25;
		
		//delta as 0.7
        assertEquals(result, expectedResult, 0.7); 
		
	}
}