package com.retaillite.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			// WebResource webResource = client
			// .resource("http://localhost:8085/RetailLite/rest/json/Store/get?StoreNum=1");
			WebResource webResource = client.resource(
					"http://localhost:8085/RetailLite/rest/json/Cart/delete?Cart_Uid=1&telNum=9820107598&Product_upc=1");

			/*
			 * WebResource webResource = client .resource(
			 * "http://localhost:8085/RetailLite/rest/json/Product/get?UPC=1234"
			 * );
			 */

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}