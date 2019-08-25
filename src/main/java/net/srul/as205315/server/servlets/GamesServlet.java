package net.srul.as205315.server.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/games")
public class GamesServlet extends HttpServlet {

    private static final long serialVersionUID = 410117331074670406L;

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html charset=utf8");
        response.setStatus(HttpServletResponse.SC_OK);

        final String game = request.getParameter("game");

        // TODO: hardcoded, read from a file?
        final Game[] games = new Game[] {
            new Game("Gebastellously Crochety Friend's Krücke #1 (tm) (r) all rights reserved.",
                    "GCF_Game")
        };

        final PrintWriter p = response.getWriter();

        if (game == null || game.isEmpty()) {
            // No specific game has been requested, just list them.
            p.println("<!DOCTYPE html><html><body>");
            p.println("<title>the ultimate games list (tm)</title>");
            p.println("<h1>The Ultimate List of GCF's Games (tm)</h1>");
            p.println("<ul>");
            Stream.of(games)
                .map(a -> String.format("<li><a href=/games?game=%s>%s</a></li>\n",
                            a.path, a.name))
                .forEach(p::println);
            p.println("</ul>");
            p.println("</body></html>");
        } else {
            final Game found = Stream.of(games)
                .filter(a -> a.path.equals(game))
                .findAny()
                .orElse(null);

            if (found == null) {
                // No game found, bail out.
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

                // We should give at least an error message or something, though.
                p.println("<!DOCTYPE html><html><body>");
                p.println("<title>game not found (tm)</title>");
                p.println("<h1>Game not found! (tm)</h1>");
                p.println("<p>This is probably a bug in the servlet's code. ");
                p.println("Report it or something, idk.</p>");
                p.println("<h2>OR IS IT??? (tun tun duuuuuun)</h2>");
                p.print  ("<p>What if you entered the wrong game on purpose? ");
                p.print  ("Are you trying to crash the server, you tatar hacker? ");
                p.println("I know your IP. I'll find you and murder your dog.</p>");
                p.println("</body></html>");
            } else {
                // Game found, let the user play it.
                try (final Scanner s = new Scanner(
                            Path.of(getServletContext().getRealPath(found.resource)))) {
                    while (s.hasNextLine()) {
                        p.println(s.nextLine());
                    }
                }
            }
        }
    }

    private static class Game {

        public final String name;
        public final String path;
        public final String resource;

        public Game(String name, String path) {
            this.name = name;
            this.path = path;
            this.resource = "/WEB-INF/resources/games/" + path + "/index.html";
        }
    }
}
