package com.restcalculator.logic;

import java.util.ArrayList;
import java.util.List;

import com.restcalculator.client.ICalculator;

public class GreenInvoiceGenerator 
{
	List<ProductItem> itemsList;
	
	public GreenInvoiceGenerator()
	{
		itemsList = new ArrayList<ProductItem>();
	}
	
	public void AddItem(String itemName, long itemVal)
	{
		ProductItem itm = new ProductItem();
		
		itm.name = itemName; 
		itm.price = itemVal;
		
		itemsList.add(itm);
	}
	
	public float GetGrossPrice()
	{
		float totalAmount = 0;
		
		for (ProductItem myItem : this.itemsList) 
		{
			totalAmount += myItem.price;
	    }
		
		return totalAmount;
	}
	
	public float ProcessInvoceDiscount(ICalculator calculator, int percentage)
	{
		long totalAmount = 0;
		
		for (ProductItem myItem : this.itemsList) 
		{
			totalAmount = calculator.Sum(totalAmount, myItem.price);
	    }
		
		return totalAmount - (totalAmount * percentage / 100);
	}
	
}