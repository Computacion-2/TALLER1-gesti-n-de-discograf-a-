package com.discography.servlets;

import java.io.*;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.discography.beans.MyFirstBean;
import com.discography.model.Artist;
import com.discography.service.IArtistService;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CreateArtistServlet", value = "/createartist")
public class CreateArtistServlet extends HttpServlet {

    private IArtistService artistService;

    public void init() {

        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        artistService = (IArtistService) context.getBean("artistService");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Crear Artista" + "</h1>");

        out.println("<form method='post' action='" + request.getContextPath() + "/createartist'>");
        out.println("  Nombre: <input type='text' name='name' required /><br/>");
        out.println("  nationality:  <input type='text' name='nationality' required /><br/><br/>");

        out.println("  <button type='submit'>Guardar</button>");
        out.println("</form>");

        String success = request.getParameter("success");
        if ("true".equals(success)) {
            out.println("<p style='color: green; font-weight: bold;'>¡Artista creado exitosamente!</p>");
        }

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String nationality = request.getParameter("nationality");

        Artist artist = new Artist(0, name, nationality);

        artistService.save(artist);

        response.sendRedirect(request.getContextPath() + "/createartist?success=true");

    }

    public void destroy() {
    }
}