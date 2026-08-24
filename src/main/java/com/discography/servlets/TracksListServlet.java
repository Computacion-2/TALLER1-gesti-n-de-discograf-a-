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

@WebServlet(name = "TracksListServlet", value = "/tracklist")
public class TracksListServlet extends HttpServlet {

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
        out.println("<h1>Lista de Tracks</h1>");

        out.println("<table border='1' cellpadding='5'>");
        out.println("  <thead>");
        out.println("    <tr>");
        out.println("      <th>ID</th>");
        out.println("      <th>Título</th>");
        out.println("      <th>Género</th>");
        out.println("      <th>Duración</th>");
        out.println("      <th>Álbum</th>");
        out.println("      <th>Artistas Asociados</th>");
        out.println("    </tr>");
        out.println("  </thead>");
        out.println("  <tbody>");

        for (Track track : tracks) {
            StringBuilder artistNames = new StringBuilder();
            if (track.getArtists() != null && !track.getArtists().isEmpty()) {
                for (int i = 0; i < track.getArtists().size(); i++) {
                    artistNames.append(track.getArtists().get(i).getName());
                    if (i < track.getArtists().size() - 1) {
                        artistNames.append(", ");
                    }
                }
            } else {
                artistNames.append("Sin artistas");
            }

            out.println("    <tr>");
            out.println("      <td>" + track.getId() + "</td>");
            out.println("      <td>" + track.getTitle() + "</td>");
            out.println("      <td>" + track.getGenre() + "</td>");
            out.println("      <td>" + track.getDuration() + "</td>");
            out.println("      <td>" + track.getAlbumTitle() + "</td>");
            out.println("      <td>" + artistNames.toString() + "</td>");
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