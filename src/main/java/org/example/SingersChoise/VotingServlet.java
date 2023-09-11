package org.example.SingersChoise;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class VotingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String[] ARTISTS = {"Исполнитель 1", "Исполнитель 2", "Исполнитель 3", "Исполнитель 4"};
    private static final String[] GENRES = {"Жанр 1", "Жанр 2", "Жанр 3", "Жанр 4", "Жанр 5"};

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Форма голосования</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Форма голосования</h1>");
        out.println("<form method=\"post\">");
        out.println("<p>Лучший исполнитель:</p>");
        for (int i = 0; i < ARTISTS.length; i++) {
            out.println("<input type=\"radio\" name=\"artist\" value=\"" + ARTISTS[i] + "\">" + ARTISTS[i] + "<br>");
        }
        out.println("<p>Ваши любимые жанры (выберите не менее 4):</p>");
        for (int i = 0; i < GENRES.length; i++) {
            out.println("<input type=\"checkbox\" name=\"genres\" value=\"" + GENRES[i] + "\">" + GENRES[i] + "<br>");
        }
        out.println("<br><input type=\"submit\" value=\"Отправить\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String artist = request.getParameter("artist");
        String[] genres = request.getParameterValues("genres");
        if (artist == null || genres == null || genres.length < 4) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Неверные параметры");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Результаты голосования</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Результаты голосования</h1>");
        out.println("<p>Лучший исполнитель: " + artist + "</p>");
        out.println("<p>Ваши любимые жанры:</p>");
        out.println("<ul>");
        for (int i = 0; i < genres.length; i++) {
            out.println("<li>" + genres[i] + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}