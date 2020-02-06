package com.restcalculator.unittests;

import static org.mockito.Mockito.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restcalculator.client.ICalculator;
import com.restcalculator.logic.GreenCalculator;

public class CalculatorClientTests {
	
	@Test(groups = {"unitary", "calculator"} )
	public void ShouldComputeSumOfPositiveNumbers()
	{
		   //Arrange			
		   GreenCalculator myMath = new GreenCalculator();
		   myMath.number1 = 5;
		   myMath.number2 = 6;
		   float expectedResult = 11;
		   
		   ICalculator myMockRestCalc = mock(ICalculator.class);
		   when(myMockRestCalc.Sum(any(Long.class), any(Long.class))).thenReturn(11L);

		   ///Act	
		   float actualResult = myMath.Sum(myMockRestCalc);
		   
		   //Assert
		   Assert.assertEquals(expectedResult, actualResult, "Error en la operación suma");
	}	
	
}