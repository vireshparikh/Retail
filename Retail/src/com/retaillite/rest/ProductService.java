package com.retaillite.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.retaillite.dao.Dao;
import com.retaillite.pojo.Product;

@Path("/json/Product")
public class ProductService {

	Dao dao = new Dao();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@QueryParam("UPC") String upc) {
		System.out.println("$$$$$" + upc);
		return dao.getProductDetails(upc);

	}

}
