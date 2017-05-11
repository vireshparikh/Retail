package com.retaillite.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.retaillite.dao.Dao;
import com.retaillite.pojo.Order;

@Path("/json/Order")
public class OrderService {

	Dao dao = new Dao();
	String error = "Error while doing operation. Please contact admin.";

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderDetails(@QueryParam("telNum") String telNum) {
		System.out.println("telnum" + telNum);

		Order ord = dao.getOrderDetails(telNum);
		if (null != ord) {
			return Response.status(201).entity(ord).build();
		} else {
			return Response.status(500).entity(error).build();
		}
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveOrder(Order ord) {
		String result = "Order saved : " + ord;
		if (dao.saveOrder(ord)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(Order ord) {
		String result = "Order updated : " + ord;
		if (dao.updateOrder(ord)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOrder(Order ord) {
		String result = "Order deleted : " + ord;
		if (dao.deleteOrder(ord)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}
	}

}
