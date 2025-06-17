package com.example.gms.admin.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.gms.adminanduser.service.IParticipantService;
import com.example.gms.adminanduser.service.ParticipantServiceImpl;
import com.example.gms.model.Participants;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParticipantsServlet
 */

public class ParticipantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(ParticipantsServlet.class.getName());

	private IParticipantService participantService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParticipantsServlet() {
		super();
		// TODO Auto-generated constructor stub
		participantService = new ParticipantServiceImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("I am in doGet method of ParticipantsServlet");

		// Placeholder
		Participants retrievedParticipant = null;

		try {
			retrievedParticipant = participantService.getParticipant(Long.parseLong(request.getParameter("id")));
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

		System.out.println("I am inside my ParticipantsServlet");
		String type = request.getParameter("type");

		if (("createParticipant".equals(type))) {
			Participants participants = loadObject(request);

			try {
				participantService.saveParticipant(participants);

				request.setAttribute("successMessage", "Participant added successfully!");
				request.setAttribute("participant", participants);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/participant-views.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {

				request.setAttribute("errorMessage", e);

				request.getRequestDispatcher("/participant-views-error.jsp").forward(request, response);
			}

		} else if ("updateParticipant".equals(type)) {

			Participants participantsUpdate = loadObject(request);

			try {
				participantService.updateParticipant(participantsUpdate);
				System.out.println(participantsUpdate);
				request.setAttribute("successMessage", "Participant object Updated successfully!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/participants-admin.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("update failure!: ");
				e.printStackTrace();
				e.getMessage();

			}
		}

	}

	private Participants loadObject(HttpServletRequest request) {

		Participants participants = new Participants();

		if (request.getParameter("participantId") != null) {
			String participantId = request.getParameter("participantId");
			participants.setPid(Integer.parseInt(participantId));
		}

		participants.setName(request.getParameter("participantName"));
		participants.setPhone(request.getParameter("participantPhone"));
		participants.setEmail(request.getParameter("participantEmail"));
		Integer bid = Integer.parseInt(request.getParameter("batchId"));
		participants.setBid(bid);
		return participants;
	}
}
