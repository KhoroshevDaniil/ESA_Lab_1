package com.example.servlet;

import com.example.model.Participant;
import com.example.service.ParticipantService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "participantServlet", value = "/participants")
public class ParticipantServlet extends HttpServlet {
    @EJB
    private ParticipantService participantService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Participant> participants = participantService.getAll();
        request.setAttribute("participants", participants);
        request.getRequestDispatcher("/participants.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String academicDegree = request.getParameter("academic_degree");

        Participant newParticipant = new Participant();
        newParticipant.setName(name);
        newParticipant.setAge(age);
        newParticipant.setAcademicDegree(academicDegree);
        participantService.save(newParticipant);

        doGet(request, response);
    }
}
