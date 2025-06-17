package com.example.gms.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */

public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(FrontControllerServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestType = request.getParameter("type");

		RequestDispatcher dispatcher = null;

		if ("createParticipant".equals(requestType) || "updateParticipant".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("participants");
		} else if ("batch".equals(requestType) || "createBatch".equals(requestType)
				|| "updateBatch".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("Batch");
		} else if ("login".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("login");
		} else if ("home".equals(requestType)) {
			dispatcher = request.getRequestDispatcher("home");
		} else {
			dispatcher = request.getRequestDispatcher("error");
		}

		dispatcher.forward(request, response);
	}
}