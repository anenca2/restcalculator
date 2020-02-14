package com.restcalculator.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.*;

public class CalculatorClient implements ICalculator{
  
	Client client;
	private String serverUrl = "https://newton.now.sh/";
	
	public CalculatorClient()
	{
		client = Client.create();
		client.setConnectTimeout(30000);
	}
	 
	public long Sum(long a, long b)
	{
			try 
			{
				String jsonResp = doGetRequest("simplify/" + a + "+" + b);	
				return substractResult(jsonResp);	
			} 
			catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}
	
	private int substractResult(String jsonResult)
	{
		JSONObject obj = new JSONObject(jsonResult);
		String result = obj.getString("result");
		return Integer.parseInt(result);
	}
	
	private  String doGetRequest(String completeRequestUrl) throws Exception {
		String resStr = "";        
		//
		WebResource webResource = client.resource(serverUrl + completeRequestUrl);
		ClientResponse response = null;
		//
		response = webResource.accept("application/json")
					.header("Connection", "Close")
					.get(ClientResponse.class);
		//
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		//
		resStr = response.getEntity(String.class);
		//
		return resStr;
	}
}