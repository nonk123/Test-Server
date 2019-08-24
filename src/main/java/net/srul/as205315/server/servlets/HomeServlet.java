package net.srul.as205315.server.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 7084469917477033994L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // WARNING: a very long line.
        final String wgw = "One day while Andy was masturbating, Woody got wood. He could no longer help himself! He watched as Andy stroked his juicy kawaii cock. He approached Andy which startled him and make him pee everywhere on the floor and on Woody too. Being drenched in his urine made him harder than ever! Woody: \"Andy Senpai! I'm alive and I want to be INSIDE OF YOU.\" Andy: \"Oh Woody Chan! I always knew you were alive! I want to stuff you up my kawaii ass!\" Woody grabbed a bunch of flavored lube and rubbed it all over his head Woody: \"Oh my! It's cherry flavored lube! Cherry is my favorite! Woody then stuffed his head up into Andy's tight ass! The other toys around the room watched intently as Woody shoved his head back and forth into Andy's nice ass, continuously making a squishy wet noise. The other toys also became aroused and they all gathered around Woody and Andy and started to urinate all over them, and then they started to masturbate. Andy: \"Oh my goodness, Woody Chan! You are churning my insides up so well! Your nose is stimulating my prostate! OH YES! All the other toys became so aroused by this, that they could not help themselves anymore! They pushed Woody completely inside, and they all went inside. All of them wanted to be inside Andy's nice round ass. Andy: \"No wait guys! My ass cannot hold this much! I'm getting so full! All the toys went inside of poor squirming Andy and pretty much, he was beyond full, and died from having his insides completely damaged. The mother came inside and found Andy, dead with a huge ass hemorrhage on his anus, with a HUGE belly full of toys.";

        response.setContentType("text/html; charset=utf8");
        response.setStatus(HttpServletResponse.SC_OK);

        // TODO: replace with something else, or at least make it non-hardcoded.
        response.getWriter().println(
              "<!DOCTYPE html><html><body>\n"
            + "<title>nonk's homepage (tm)</title>\n"
            + "<h1>Welcome to WGW fan club! Have a good day!</h1>\n"
            + "<h2>WGW in its true form</h2>\n"
            + String.format("<p>%s</p>\n", wgw)
            + "<h1>If you're still here, go ahead and read these awesome WGW spin-offs!</h1>\n"
            + "<h2>Cattus' got Wood</h2>\n"
            + String.format("<p>%s</p>\n", wgw.replace("Andy", "Nonk").replace("Woody", "Cattus"))
            + "<h1>Here are some offensive, but still very good WGW spin-offs</h1>\n"
            + "<h2>Voin's got Wood</h2>\n"
            + String.format("<p>%s</p>\n", wgw.replace("Andy", "J-RB").replace("Woody", "Voin"))
            + "</body></html>"
        );
    }
}
