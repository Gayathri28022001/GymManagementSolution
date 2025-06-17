package com.example.gms.admin.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.gms.adminanduser.service.BatchServiceImpl;
import com.example.gms.adminanduser.service.IBatchService;
import com.example.gms.model.Batch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BatchServlet
 */

public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(BatchServlet.class.getName());

	private IBatchService batchService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BatchServlet() {
		super();
		// TODO Auto-generated constructor stub
		batchService = new BatchServiceImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("I am in doGet method of BatchServlet");

		// Placeholder
		Batch retrievedBatch = null;

		try {
			retrievedBatch = batchService.getBatch(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("I am inside my BatchServlet");

		String type = request.getParameter("type");

		if (("createBatch".equals(type))) {

			Batch batch = loadObject(request);

			try {
				batchService.saveBatch(batch);

				request.setAttribute("successMessage", "Batch added successfully!");
				request.setAttribute("batch", batch);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/batch-views.jsp");
				dispatcher.forward(request, response);

			} catch (Exception e) {

				request.setAttribute("errorMessage", e);

				request.getRequestDispatcher("/batch-views-error.jsp").forward(request, response);
			}

		} else if ("updateBatch".equals(type)) {

			Batch batchUpdate = loadObject(request);

			try {
				batchService.updateBatch(batchUpdate);
				System.out.println(batchUpdate);
				request.setAttribute("successMessage", "Batch object Updated successfully!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/batch-admin.jsp");
				dispatcher.forward(request, response);
				return;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("update failure!: ");
				e.printStackTrace();
				e.getMessage();
			}
		}

	}

	private Batch loadObject(HttpServletRequest request) {

		Batch batch = new Batch();

		String batchId = request.getParameter("batchId");
		if (batchId != null && !batchId.trim().isEmpty()) {
			try {
				batch.setBid(Integer.parseInt(batchId.trim()));
			} catch (NumberFormatException e) {
				System.err.println("Invalid batchId: " + batchId);
			}

		}

		batch.setBatchName(request.getParameter("batchName"));
		batch.setTimeSlot(request.getParameter("batchTimeSlot"));
		batch.setTrainerName(request.getParameter("batchTrainerName"));
		return batch;
	}

}
