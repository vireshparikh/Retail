package com.retaillite.rest;

import java.util.List;

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
import com.retaillite.pojo.Queue;

@Path("/json/Queue")
public class QueueService {

	Dao dao = new Dao();
	String error = "Error while doing operation. Please contact admin.";

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQueueDetails(@QueryParam("telNum") String telNum) {
		System.out.println("telnum" + telNum);
		Queue q = new Queue();
		q.setCq_Customer_Number("1234");
		q.setCq_Status("Processing");
		q.setCq_UID(1);
		// Order ord = dao.getOrderDetails(telNum);
		return Response.status(201).entity(q).build();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveQueue(Queue que) {
		String result = "Queue record saved : " + que;
		if (dao.saveQueue(que)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQueue(Queue que) {
		String result = "Queue updated : " + que;
		if (dao.updateQueue(que)) {
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(500).entity(error).build();
		}
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQueue(Queue que) {
		String result = "Operation not supported";
		/* if (dao.deleteQueue(que)) { */
		return Response.status(201).entity(result).build();
		/*
		 * } else { return Response.status(500).entity(error).build(); }
		 */
	}

	public List<Queue> getAllRecordsQueue() {

		// Order ord = dao.getOrderDetails(telNum);
		return dao.getQueueList();
	}

}
