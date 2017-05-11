package com.retaillite.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8085/RetailLite/rest/json/Cart/post");

			String input = "{\"cart_Customer_Number\":9869500511,\"cart_Order_Paid_Flag\":1,\"cart_Quantity\":2,\"cart_Total\":299,\"product_UPC\":2,\"cart_UID\":1}";
			// String input =
			// "{\"order_Total\":22.77,\"order_UID\":1,\"order_Payment_Method\":\"CASH\",\"cart_Customer_Number\":\\"111\",\"order_Payment_Amount\":22.22}";
			// String
			// input="{\"start_DateTime\":null,\"cq_Customer_Number\":\"9820107598\",\"cq_UID\":1,\"end_DateTime\":null,\"cq_Status\":\"Processing\"}";

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

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
