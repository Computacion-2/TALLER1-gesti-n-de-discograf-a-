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

@WebServlet(name = "DeleteArtistServlet", value = "/deleteartist")
public class DeleteArtistServlet extends HttpServlet {

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
        out.println("<h1>" + "Eliminar Artista" + "</h1>");

        out.println("<form method='GET'>");
        out.println("  ID: <input type='number' name='id' placeholder='ID del artista'><br><br/>");

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

        Artist artist = artistService.deleteById(Integer.parseInt(id));

        if (artist == null) {
            out.println("<p>Artista no encontrado.</p>");
            return;
        } else {
            out.println("<p>Artista eliminado.</p>");
        }

    }

    public void destroy() {
    }
}