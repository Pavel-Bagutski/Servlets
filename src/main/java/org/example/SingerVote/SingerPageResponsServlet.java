package org.example.SingerVote;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet(urlPatterns = "/singleChoice")
public class SingerPageResponsServlet extends HttpServlet {

    CounterVote counterVote;

    List<CounterVote> singersList = new ArrayList<>();

    String GENRES_NAME_PARAMETER = "genres";
    List<CounterVote> genresList = new ArrayList<>();

    List <TextTime> textList = new ArrayList<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String singerStr = req.getParameter("singer");
        String[] genresArray = req.getParameterMap().get(GENRES_NAME_PARAMETER);
        String message = req.getParameter("message");

        if (singerStr != null & genresArray.length >= 4 )  {

            //Voting Singer
            if (singerStr != null) {
                counterVote = new CounterVote(singerStr);
                if (singersList.contains(counterVote)) {
                    for (CounterVote c : singersList) {
                        if (counterVote.equals(c)) {
                            c.increment();
                        }
                    }
                } else singersList.add(counterVote);
            }
            Collections.sort(singersList, new Comparator<CounterVote>() {
                @Override
                public int compare(CounterVote o1, CounterVote o2) {
                    return Integer.compare(o2.getCount(), o1.getCount());
                }
            });

            // Voting Genres
            for (String s : genresArray) {
                counterVote = new CounterVote(s);
                if (genresList.contains(counterVote)) {
                    for (CounterVote c : genresList) {
                        if (counterVote.equals(c)) {
                            c.increment();
                        }
                    }
                } else genresList.add(counterVote);
            }

            Collections.sort(genresList, new Comparator<CounterVote>() {
                @Override
                public int compare(CounterVote o1, CounterVote o2) {
                    return Integer.compare(o2.getCount(), o1.getCount());
                }
            });

            // message
            String emptyString = "";
            if (!message.equals(emptyString)) {
                long time = System.currentTimeMillis();
                TextTime textTime = new TextTime(message);
                textList.add(textTime);
            }
            Collections.sort(textList, new Comparator<TextTime>() {
                @Override
                public int compare(TextTime o1, TextTime o2) {
                    return Integer.compare((int) o2.getTime(), (int) o1.getTime());
                }
            });
        }else resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "incorrect input! enter all fields and select at least 4 genres ");

        writer.println("<html>");
        writer.write("<head>");
        writer.write("<title>info</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>VOTING</h1>");
        writer.write("<p>Best singer - " + singersList.get(0).toString() + "</p>");
        writer.write("<p>Best genres - " + genresList.get(0).toString() + "</p>");
        writer.write("<p>Last comment:  " + textList.get(0).toString()  + "</p>");
        writer.write("</body>");

    }
}
