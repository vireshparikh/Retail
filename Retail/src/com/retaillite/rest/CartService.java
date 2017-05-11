package com.retaillite.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.retaillite.dao.Dao;
import com.retaillite.pojo.Cart;

@Path("/json/Cart")
public class CartService {

	Dao dao = new Dao();
	String error = "Error while doing operation. Please contact admin.";

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCartDetails(@QueryParam("telNum") String telNum) {
		System.out.println("telnum" + telNum);
		List<Cart> lst = dao.getCartDetails(telNum);

		/*
		 * Gson gsn = new Gson(); String json = gsn.toJson(lst);
		 * System.out.println(json);
		 * 
		 * 
		 * Gson gson = new Gson(); String jsonStudents = gson.toJson(lst);
		 * System.out.println("jsonStudents = " + jsonStudents); JSONObject obj
		 * = new JSONObject(); obj.put("lst", jsonStudents); Type type = new
		 * TypeToken<List<Cart>>() {}.getType();
		 */

		if (lst.size() > 0) {
			return Response.status(200).entity(lst).build();
		} else {
			return Response.status(500).entity(error).build();
		}

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCart(Cart crt) {
		String result = "Cart saved : " + crt;
		if (dao.saveCart(crt)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCart(Cart crt) {
		String result = "Cart updated : " + crt;
		if (dao.updateCart(crt)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}
	}

	@GET
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCart(@QueryParam("Cart_Uid") Integer cart_Uid, @QueryParam("telNum") String telNum,
			@QueryParam("Product_upc") String upc) {
		String result = "Cart deleted : " + cart_Uid;
		if (dao.deleteCart(cart_Uid, telNum, upc)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}
	}
}
