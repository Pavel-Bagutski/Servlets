package org.example.SingersChoise;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = "/singer")
public class VotingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String[] ARTISTS = {"Каста", "Basta", "Исполнитель 3", "Исполнитель 4"};
    private static final String[] GENRES = {"Жанр 1", "Жанр 2", "Жанр 3", "Жанр 4", "Жанр 5"};


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Voting Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Voting Form</h1>");
        out.println("<form method=\"post\">");
        out.println("<p>Best artist:</p>");
        for (int i = 0; i < ARTISTS.length; i++) {
            out.println("<input type=\"radio\" name=\"artist\" value=\"" + ARTISTS[i] + "\">" + ARTISTS[i] + "<br>");
        }
        out.println("<p>Your favorite genres (select at least 4):</p>");
        for (int i = 0; i < GENRES.length; i++) {
            out.println("<input type=\"checkbox\" name=\"genres\" value=\"" + GENRES[i] + "\">" + GENRES[i] + "<br>");
        }
        out.println("<br><input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        // Сохраняем значения в атрибуты объекта HttpServletRequest
        request.setAttribute("artists", ARTISTS);
        request.setAttribute("genres", GENRES);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String artist = request.getParameter("artist");
        String[] genres = request.getParameterValues("genres");
        if (artist == null || genres == null || genres.length < 4) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Voting Resultswewwewee</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Voting Results</h1>");
        out.println("<p>Best artist: " + artist + "</p>");
        out.println("<p>Your favorite genres:</p>");
        out.println("<ul>");
        for (int i = 0; i < genres.length; i++) {
            out.println("<li>" + genres[i] + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

        // Извлекаем значения из атрибутов объекта HttpServletRequest
        String[] artists = (String[]) request.getAttribute("artists");
        String[] genresList = (String[]) request.getAttribute("genres");
    }
}
