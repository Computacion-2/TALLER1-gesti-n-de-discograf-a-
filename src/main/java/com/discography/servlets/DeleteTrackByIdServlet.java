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

@WebServlet(name = "DeleteTrackByIdServlet", value = "/deletetrack")
public class DeleteTrackByIdServlet extends HttpServlet {

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
        out.println("<h1>" + "Eliminar Track" + "</h1>");

        out.println("<form method='GET'>");
        out.println("  ID: <input type='number' name='id' placeholder='ID del track'><br><br/>");

        out.println("  <button type='submit'>Eliminar</button>");
        out.println("</form>");

        out.println(
                "<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li>");
        out.println("</body></html>");

        String id = request.getParameter("id");

        // Si todavía no han buscado nada
        if (id == null) {
            return;
        }

        Track track = trackService.deleteById(Integer.parseInt(id));

        if (track == null) {
            out.println("<p>Track no encontrado.</p>");
            return;
        } else {
            out.println("<p>Track eliminado.</p>");
        }

    }

    public void destroy() {
    }
}