package com.restcalculator.integrationtests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.restcalculator.client.CalculatorClient;

public class CalculatorClientTests {

	
	@Test(groups = {"integration", "calculator"} )
	public void ShuldSumPositiveNumbersTest()
	{
	   //Arrange
	   int positiveNum1 = 5;
	   int positiveNum2 = 6;
	   float expectedResult = 11;
		
	   ///Act
	   CalculatorClient cc = new CalculatorClient();
	   float actualResult = cc.Sum(positiveNum1, positiveNum2);
	   
	   //Assert
	   Assert.assertEquals(expectedResult, actualResult);
	}
}
