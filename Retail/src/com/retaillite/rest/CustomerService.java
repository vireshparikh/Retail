package com.retaillite.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.retaillite.dao.Dao;
import com.retaillite.pojo.Customer;

@Path("/json/Customer")
public class CustomerService {

	Dao dao = new Dao();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@QueryParam("telNumber") String telnum) {
		System.out.println("$$$$$" + telnum);
		return dao.getCustomer(telnum);

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCustomer(Customer cust) {

		String result = "Customer saved : " + cust;
		return Response.status(201).entity(result).build();

	}

}
