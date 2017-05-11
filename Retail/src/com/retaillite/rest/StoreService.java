package com.retaillite.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.retaillite.dao.Dao;
import com.retaillite.pojo.Store;;

@Path("/json/Store")
public class StoreService {

	Dao dao = new Dao();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Store getProduct(@QueryParam("StoreNum") String strnum) {
		System.out.println("$$$$$" + strnum);
		return dao.getStoreDetails(strnum);

	}

}