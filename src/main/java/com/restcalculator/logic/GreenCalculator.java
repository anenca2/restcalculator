package com.restcalculator.logic;

import com.restcalculator.client.ICalculator;

public class GreenCalculator {

	public int number1;
	public int number2;
	
	public GreenCalculator()
	{
	}
		
	public long Sum(ICalculator calculator)
	{
		return calculator.Sum(this.number1, this.number2);
	}
	
}