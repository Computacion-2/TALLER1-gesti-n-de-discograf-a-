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
        out.println("<h1>" + "Lista de Tracks" + "</h1>");

        out.println("<ul>");

        for (Track track : tracks) {
            out.println(
                    "<li>" + track.getAlbumTitle() + " " + track.getDuration() + " " + track.getTitle() + " "
                            + track.getGenre() + " " + track.getId()
                            + "</li>");

        }

        out.println("</ul>");

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}