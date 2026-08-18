package com.discography.servlets;

import java.io.*;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.discography.beans.MyFirstBean;
import com.discography.model.Artist;
import com.discography.model.Track;
import com.discography.service.IArtistService;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SearchArtistServlet", value = "/searchartist")
public class SearchArtistServlet extends HttpServlet {

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
        out.println("<h1>" + "Buscar Artista" + "</h1>");

        out.println("<form method='GET'>");
        out.println("  Nombre: <input type='text' name='name' placeholder='Nombre del artista'><br><br/>");

        out.println("  <button type='submit'>Buscar</button>");
        out.println("</form>");

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");

        String name = request.getParameter("name");

        // Si todavía no han buscado nada
        if (name == null || name.isBlank()) {
            return;
        }

        Artist artist = artistService.getArtistByName(name);

        if (artist == null) {
            out.println("<p>Artista no encontrado.</p>");
            return;
        }

        out.println("<h2>" + artist.getName() + "</h2>");
        out.println("<p>ID: " + artist.getId() + "</p>");
        out.println("<p>Nacionalidad: " + artist.getNationality() + "</p>");

        out.println("<h3>Tracks</h3>");

        for (Track track : artist.getTracks()) {
            out.println(
                    "<p>" +
                            track.getTitle() +
                            " - " +
                            track.getGenre() +
                            "</p>");
        }

    }

    public void destroy() {
    }
}