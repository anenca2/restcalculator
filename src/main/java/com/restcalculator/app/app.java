package com.restcalculator.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.restcalculator.client.CalculatorClient;
import com.restcalculator.logic.GreenInvoiceGenerator;


public class app {

	public static void main(String[] args) throws IOException 
	{
		String opc = "0";
		GreenInvoiceGenerator invoiceGenerator = new GreenInvoiceGenerator();	
		
		while (!opc.equals("9")) 
		{	
		    clearConsole(); 
			System.out.println();
			System.out.println("********************************************");
			System.out.println("*         **** POS Application ****         *");
			System.out.println("********************************************");
			System.out.println(" Application Options");
			System.out.println();
			System.out.println(" 1 - Add items");
			System.out.println(" 2 - Calculate invoice");
			System.out.println(" 9 - Exit");
			System.out.println();
			System.out.print(" Enter your option: ");					
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opc = br.readLine();
						
			//Select option
			switch (opc) {
			case "1":
				EnterItem(invoiceGenerator);
				break;

			case "2":
				ProcessInvoice(invoiceGenerator);
				break;
			}
		}
		
		System.out.println("Bye!!!!....");
	}
	
	private static void EnterItem(GreenInvoiceGenerator invoiceGenerator) 
			throws IOException
	{
		System.out.println("Product name: ");		
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String itemName = br1.readLine();

		
		System.out.println("Product price: ");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String strItemValue = br2.readLine();
		
		invoiceGenerator.AddItem(itemName, Integer.parseInt(strItemValue));
		
		System.out.println("Added element");
		delayConsole();
	}
	
	private static void ProcessInvoice (GreenInvoiceGenerator invoiceGenerator) throws IOException
	{
		CalculatorClient cc = new CalculatorClient();
		
		float grossPrice = invoiceGenerator.GetGrossPrice();
		float totalDiscounted = invoiceGenerator.ProcessInvoceDiscount(cc, 80);
		
		
		System.out.println("Gross price: " + String.valueOf(grossPrice));
		System.out.println("Net price: " + String.valueOf(totalDiscounted));
		System.out.println("Calculation finished!");
		delayConsole();
	}	
	
	private static void delayConsole()
	{
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	        {
	            System.out.print("\033[H\033[2J");  
	            System.out.flush();  
	        }
	    }
	    catch (final Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}
