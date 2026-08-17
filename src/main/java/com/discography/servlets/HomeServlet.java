package com.discography.servlets;

import java.io.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.discography.beans.MyFirstBean;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "MENU DISCOGRAFIA" + "</h1>");
        out.println("<ul>");
        out.println(
                "<li>1. Listado de artistas <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>2. Crear artista <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>3. Buscar artista por nombre <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>4. Eliminar artista por id <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>5. Listado de tracks <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>6. Crear tracks <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>7. Buscar tracks por id <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>8. Eliminar tracks por id <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</ul>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}