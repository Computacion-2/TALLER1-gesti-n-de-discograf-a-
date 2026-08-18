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
import com.discography.service.ITrackService;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SearchTracksByIdServlet", value = "/searchtracks")
public class SearchTracksByIdServlet extends HttpServlet {

    private ITrackService trackService;

    public void init() {

        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        trackService = (ITrackService) context.getBean("trackService");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Track> tracks = trackService.getAllTracks();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Buscar Tracks" + "</h1>");

        out.println("<form method='GET'>");
        out.println("  ID: <input type='text' name='id' placeholder='ID del track'><br><br/>");

        out.println("  <button type='submit'>Buscar</button>");
        out.println("</form>");

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");

        String id = request.getParameter("id");

        // Si todavía no han buscado nada
        if (id == null || id.isBlank()) {
            return;
        }

        Track track = trackService.getTrackById(Integer.parseInt(id));

        if (track == null) {
            out.println("<p>Track no encontrado.</p>");
            return;
        }

        out.println("<h2>" + track.getTitle() + "</h2>");
        out.println("<p>ID: " + track.getId() + "</p>");
        out.println("<p>Genero: " + track.getGenre() + "</p>");
        out.println("<p>Duracion: " + track.getDuration() + "</p>");
        out.println("<p>Album: " + track.getAlbumTitle() + "</p>");

        out.println("<h3>Artists</h3>");

        for (Artist artist : track.getArtists()) {
            out.println(
                    "<p>" +
                            artist.getName() +
                            " - " +
                            artist.getNationality() +
                            "</p>");
        }

    }

    public void destroy() {
    }
}