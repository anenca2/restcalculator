package com.restcalculator.unittests;

import static org.mockito.Mockito.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restcalculator.client.ICalculator;
import com.restcalculator.logic.GreenInvoiceGenerator;

public class InvoiceGeneratorTests {
	
	@Test(groups = {"unitary", "invoiceGenerator"} )
	public void ShouldComputeDiscountPercentage()
	{
		   //Arrange			
		   GreenInvoiceGenerator myInvoice = new GreenInvoiceGenerator();
		   myInvoice.AddItem("Newyork Steak", 30);
		   myInvoice.AddItem("Sushi", 60);
		   myInvoice.AddItem("Postre", 10);
		   int discountPercentage = 30;
		   float expectedResult = 70;
		   
		   ICalculator myMockRestCalc = mock(ICalculator.class);

		   when(myMockRestCalc.Sum(any(Long.class), any(Long.class))).thenAnswer(i -> {
		        Long a  = i.getArgument(0);
		        Long b  = i.getArgument(1);
		        return a+b;
		    });

		   ///Act	
		   float actualResult = myInvoice.ProcessInvoceDiscount(myMockRestCalc, discountPercentage);
		   
		   //Assert
		   Assert.assertEquals( expectedResult, actualResult, "Discount percentage error");
	}
}