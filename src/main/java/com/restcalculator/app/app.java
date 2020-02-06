package com.restcalculator.app;

import java.io.IOException;

import com.restcalculator.client.CalculatorClient;
import com.restcalculator.logic.GreenInvoiceGenerator;

import jline.console.ConsoleReader;

public class app {

	public static void main(String[] args) throws IOException 
	{
		String opc = "0";
		GreenInvoiceGenerator invoiceGenerator = new GreenInvoiceGenerator();
		ConsoleReader myConsole = new ConsoleReader();
		myConsole.clearScreen();
		
		//Does not do nothing
		int nothingToDo = 0;
		int againNothingToDo = 1;
		int decla = 0;
		int acla = decla * 2;
		if(decla > acla)
		{
			if (decla<acla)
			{
				acla = decla;
				if (decla == acla)
				{
					decla = 1;
					if (decla!=acla)
					{
						decla = 3;
					}
				}
			}
		}
		
		while (!opc.equals("9")) 
		{	
			myConsole.clearScreen();
			myConsole.println();
			myConsole.println("         **** Aplicación POS ****");		
			myConsole.println(" Opciones del aplicativo");
			myConsole.println();
			myConsole.println(" 1 - Para adicionar elementos");
			myConsole.println(" 2 - Para liquidar factura");
			myConsole.println(" 9 - Para salir");
			myConsole.println();
			
			opc = myConsole.readLine("Digite su opción: ");			
			myConsole.clearScreen();
			myConsole.flush(); 
			
			switch (opc) {
			case "1":
				EnterItem(myConsole, invoiceGenerator);
				break;

			case "2":
				ProcessInvoice(myConsole, invoiceGenerator);
				break;
			}
		}
		
		myConsole.close();
	}
	
	private static void EnterItem(ConsoleReader myConsole, GreenInvoiceGenerator invoiceGenerator) 
			throws IOException
	{
		String itemName = myConsole.readLine("Nombre del producto: ");
		String strItemValue = myConsole.readLine("Precio del producto: ");
		
		invoiceGenerator.AddItem(itemName, Integer.parseInt(strItemValue));
		
		myConsole.readLine("Elemento agregado, presione <enter> para retornar");
	}
	
	private static void ProcessInvoice(ConsoleReader myConsole, GreenInvoiceGenerator invoiceGenerator) throws IOException
	{
		CalculatorClient cc = new CalculatorClient();
		
		float grossPrice = invoiceGenerator.GetGrossPrice();
		float totalDiscounted = invoiceGenerator.ProcessInvoceDiscount(cc, 80);
		
		myConsole.println("Precio bruto: " + String.valueOf(grossPrice));
		myConsole.println("Precio neto: " + String.valueOf(totalDiscounted));
		myConsole.readLine("Calculo efectuado, presione <enter> para retornar");
	}	
}