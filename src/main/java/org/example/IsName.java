package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
@WebServlet(urlPatterns = "/moreName")
public class IsName extends HttpServlet {

    private String NAME = "name";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write ("<p4>");
        writer.write ("Hello my daring ");
        writer.write ("</p4>");

        String [] strName = req.getParameterMap().get(NAME);


        /*for (int i = 0; i <strName.length ; i++) {
            String p = "<p" + i + ">";
            String pSl = "</p" + i + ">";
            writer.write(p);
            writer.write(strName[i]);
            writer.write(pSl);
        }*/

        if(strName != null){
        for (String name: strName) {
            writer.write("<p>" + NAME + ": "+ name +  "</p>");
            writer.write("                ");
            //writer.write(req.getQueryString());
        }
        }

        writer.write("");
        writer.write("");
        writer.write("");
        writer.write("");

        }


        /*String [] names = req.getParameterMap().get("name");
        if(names != null){
            for (String name: names) {
                writer.write(isName);

            }
        }
        String name  = req.getParameter("name");
            writer.write("validate name  " + name   );*/

}

