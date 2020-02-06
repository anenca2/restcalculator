package com.restcalculator.integrationtests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.restcalculator.client.CalculatorClient;
import com.restcalculator.logic.GreenInvoiceGenerator;

public class InvoiceGeneratorTests {
	
	@Test(groups = {"integration", "invoiceGenerator"} )
	public void ShouldComputeDiscountPercentage()
	{
		   //Arrange			
		   GreenInvoiceGenerator myInvoice = new GreenInvoiceGenerator();
		   myInvoice.AddItem("Jugo de mora", 5);
		   myInvoice.AddItem("Mojito", 15);
		   myInvoice.AddItem("Newyork Steak",30);
		   myInvoice.AddItem("Postre mini tipo 1", 5);
		   myInvoice.AddItem("Postre mini tipo 2", 5);
		   int discountPercentage = 30;
		   float expectedResult = 42;
		   
		   CalculatorClient cc = new CalculatorClient();

		   ///Act	
		   float actualResult = myInvoice.ProcessInvoceDiscount(cc, discountPercentage);
		   
		   //Assert
		   Assert.assertEquals(expectedResult, actualResult, "Discount percentage error");
	}
	
}