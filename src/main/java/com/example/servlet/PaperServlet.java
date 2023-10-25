package com.example.servlet;

import com.example.model.Paper;
import com.example.model.Participant;
import com.example.service.PaperService;
import com.example.service.ParticipantService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "paperServlet", value = "/papers")
public class PaperServlet extends HttpServlet {
    @EJB
    private PaperService paperService;

    @EJB
    private ParticipantService participantService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Paper> papers = paperService.getAll();
        request.setAttribute("papers", papers);
        request.getRequestDispatcher("/papers.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String authorName = request.getParameter("author");

        Participant author = participantService.getByName(authorName);
        if (author == null) {
            author = new Participant();
            author.setName(authorName);
            participantService.save(author);
        }

        Paper newPaper = new Paper();
        newPaper.setTitle(title);
        newPaper.setYear(year);
        newPaper.setAuthor(author);
        paperService.save(newPaper);

        doGet(request, response);
    }
}
