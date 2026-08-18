package com.discography.servlets;

import java.io.*;

import java.util.List;

import java.util.ArrayList;

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

@WebServlet(name = "CreateTrackServlet", value = "/createtrack")
public class CreateTrackServlet extends HttpServlet {

    private ITrackService trackService;
    private IArtistService artistService;

    public void init() {

        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        trackService = (ITrackService) context.getBean("trackService");

        artistService = (IArtistService) context.getBean("artistService");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Artist> artists = artistService.getAllArtists();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Crear Track" + "</h1>");

        out.println("<form method='post' action='" + request.getContextPath() + "/createtrack'>");
        out.println("  Title: <input type='text' name='title' required /><br/>");
        out.println("  Genre:  <input type='text' name='genre' required /><br/><br/>");
        out.println("  Duration:  <input type='text' name='duration' required /><br/><br/>");
        out.println("  Album:  <input type='text' name='album' required /><br/><br/>");

        for (Artist artist : artists) {
            out.println(
                    "<label>" +
                            "<input type='checkbox' name='artistIds' value='" + artist.getId() + "'>" +
                            artist.getName() +
                            "</label><br>");
        }

        out.println("  <button type='submit'>Guardar</button>");
        out.println("</form>");

        String success = request.getParameter("success");
        if ("true".equals(success)) {
            out.println("<p style='color: green; font-weight: bold;'>¡Track creado exitosamente!</p>");
        }

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String duration = request.getParameter("duration");
        String album = request.getParameter("album");

        List<Integer> artistIds = new ArrayList<>();
        String[] ids = request.getParameterValues("artistIds");
        if (ids != null) {
            for (String id : ids) {
                artistIds.add(Integer.parseInt(id));
            }
        }

        Track track = new Track(0, title, genre, duration, album);

        trackService.save(track, artistIds);

        response.sendRedirect(request.getContextPath() + "/createtrack?success=true");

    }

    public void destroy() {
    }
}