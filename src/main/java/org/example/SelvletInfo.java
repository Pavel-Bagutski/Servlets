package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/info")
public class SelvletInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Устанавливаем тип содержимого и кодировку
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    // для того что б считать пишем request.setCharacterEncoding("UTF-8");

    // Получаем объект PrintWriter
    PrintWriter out = response.getWriter();

    // Получаем информацию о запросе
    String method = request.getMethod();
    String uri = request.getRequestURI();
    String protocol = request.getProtocol();
    String queryString = request.getQueryString();
    String remoteAddr = request.getRemoteAddr();
    int remotePort = request.getRemotePort();
    String remoteUser = request.getRemoteUser();

    // Получаем информацию о ответе
    int status = response.getStatus();
    String contentType = response.getContentType();
    String encoding = response.getCharacterEncoding();

    // Выводим информацию на страницу
    out.println("<html>");
    out.write("<head>");
    out.write("<title>Информация о запросе и ответе</title>");
    out.write("</head>");
    out.write("<body>");
    out.write("<h1>Информация о запросе и ответе</h1>");
    out.println("<p>Метод запроса: " + method + "</p>");
    out.write("<p>URI: " + uri + "</p>");
    out.write("<p>Протокол: " + protocol + "</p>");
    out.write("<p>Строка запроса: " + queryString + "</p>");
    out.write("<p>Удаленный адрес: " + remoteAddr + "</p>");
    out.println("<p>Удаленный порт: " + remotePort + "</p>");
    out.write("<p>Удаленный пользователь: " + remoteUser + "</p>");
    out.write("<p>Код статуса ответа: " + status + "</p>");
    out.write("<p>Тип содержимого ответа: " + contentType + "</p>");
    out.write("<p>Кодировка содержимого ответа:ddfdfdf " + encoding + "cefefwefwe</p>");
    out.write("</body>");
    out.write("</html>");
    }
}
