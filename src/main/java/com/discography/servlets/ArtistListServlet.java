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
        out.println("<h1>" + "Lista de Artistas" + "</h1>");

        out.println("<ul>");

        for (Artist artist : artists) {
            out.println(
                    "<li>" + artist.getName() + " " + artist.getNationality() + " " + artist.getId() + "</li>");

        }

        out.println("</ul>");

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}