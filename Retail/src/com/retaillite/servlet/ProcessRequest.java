package com.retaillite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.retaillite.dao.Dao;

public class ProcessRequest extends HttpServlet {
	Dao dao = new Dao();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in POST");
		response.sendRedirect("/ShowQueue.jsp");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in Get" + request.getParameter("QueueId") + "status" + request.getParameter("stat"));
		dao.updateQueueList(request.getParameter("QueueId"), request.getParameter("stat"));
		response.sendRedirect("/RetailLite/ShowQueue.jsp");
	}
}
