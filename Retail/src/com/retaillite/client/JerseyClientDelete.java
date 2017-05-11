package com.retaillite.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientDelete {

	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8085/RetailLite/rest/json/Cart/delete");

			// String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To
			// Black\"}";
			String input = "{\"cart_Customer_Number\":9820107598,\"cart_Order_Paid_Flag\":1,\"cart_Quantity\":1,\"cart_Total\":99,\"product_UPC\":1234,\"cart_UID\":2}";

			ClientResponse response = webResource.type("application/json").delete(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
