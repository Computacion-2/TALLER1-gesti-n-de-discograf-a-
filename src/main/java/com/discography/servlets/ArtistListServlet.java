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

@WebServlet(name = "ArtistListServlet", value = "/artistlist")
public class ArtistListServlet extends HttpServlet {

    private IArtistService artistService;

    public void init() {

        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        artistService = (IArtistService) context.getBean("artistService");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Artist> artists = artistService.getAllArtists();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Lista de Artistas</h1>");

        out.println("<table border='1' cellpadding='5'>");
        out.println("  <thead>");
        out.println("    <tr>");
        out.println("      <th>ID</th>");
        out.println("      <th>Nombre</th>");
        out.println("      <th>Nacionalidad</th>");
        out.println("    </tr>");
        out.println("  </thead>");
        out.println("  <tbody>");

        for (Artist artist : artists) {
            out.println("    <tr>");
            out.println("      <td>" + artist.getId() + "</td>");
            out.println("      <td>" + artist.getName() + "</td>");
            out.println("      <td>" + artist.getNationality() + "</td>");
            out.println("    </tr>");
        }

        out.println("  </tbody>");
        out.println("</table><br/>");

        out.println("<p><a href='" + request.getContextPath() + "/home'><button type='button'>Ir a Home</button></a></p>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}