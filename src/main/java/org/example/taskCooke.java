package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet (urlPatterns = "/coockeServlet")
public class taskCooke extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        writer.write ("<p4>");
        writer.write ("Hello my daring ");
        writer.write ("</p4>");


        String fName =req.getParameter("firstName");
        String lName =req.getParameter("lastName");


        Cookie cookie1 = new Cookie("first", lName);
        Cookie cookie2 = new Cookie("last", fName);


        Cookie[] s = req.getCookies();


        try {
            if(fName != null || lName != null || cookie1 != null || cookie2 != null) {
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            writer.write("<p>");
            writer.write("Hello " + " " + fName + " " + lName);
            writer.write("</p>");
        }
        }
}
