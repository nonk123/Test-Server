package net.srul.as205315.server.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 7084469917477033994L;

    private String pick(String[] array, Random random) {
        synchronized (array) {
            synchronized (random) {
                final String result = array[random.nextInt(array.length)];
                final String[] variants = result.split("\\|");
                return variants[random.nextInt(variants.length)];
            }
        }
    }

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final StringBuilder wgwBuilder = new StringBuilder();

        // List of randomly generated parts of WGW.
        // TODO: load it from a file?

        final String[] characters = new String[] {
            // Two main characters and some very local meme guys.
            "Andy", "Woody", "Nonk", "Cattus", "J-RB", "Voin", "Vodak",
            "LocalDisk", "k KK"
            // Uhm, no idea what else to add to the list. It's already perfect.
        };

        // Adjectives describing Andy's genitals in the 3rd sentence. 
        // Also used for describing his butt.
        final String[] cockAdjectives = new String[] {
            "juicy|smelly", "kawaii|beautiful|nice|ugly|curved",
            "young|old", "godly", "swiss|tatar|russian|montenegrin|bosnian",
            "gigantic|enormous|large|big|small|dwarf|tiny|microscopic",
        };

        final String[] lubeFlavours = new String[] {
            "cherry", "strawberry", "banana", "grape", "chocolate", "milk",
            "strawberry and cream", "orange", "grapefruit", "apple", "beef",
            "pork", "wagyu steak", "salt", "lemon", "human flesh",
            "chicken intestine", "pigeon beak", "dog food", "cat food", "bone",
            "beer", "vodka", "horse brain"
        };

        // Inserted body parts.
        final String[] bodyparts = new String[] {
            "head", "hand", "arm", "foot", "leg", "both hands", "both arms",
            "both feet", "both legs", "entire body up to the chest",
            "left index finger", "right index finger", "tongue", "nose"
        };

        final Random random = new Random();

        // Randomly generate the main characters.
        final String andy = pick(characters, random);

        String woody = "";
        do {
            woody = pick(characters, random);
        } while (andy.equals(woody));

        // Cock and ass descriptions are random, too.
        final String cockAdjectiveFirst = pick(cockAdjectives, random);

        String cockAdjectiveSecond = "";
        do {
            cockAdjectiveSecond = pick(cockAdjectives, random);
        } while (cockAdjectiveFirst.equals(cockAdjectiveSecond));

        final String assAdjectiveFirst = pick(cockAdjectives, random);
        final String assAdjectiveSecond = pick(cockAdjectives, random);

        // Bodypart to be inserted.
        final String bodypart = pick(bodyparts, random);

        // Lube flavour.
        final String lubeFlavour = pick(lubeFlavours, random);

        // Here it comes.
        wgwBuilder.append("One day while ").append(andy).append(" ");
        wgwBuilder.append("was masturbating, ").append(woody).append(" got wood. ");
        wgwBuilder.append("He could no longer help himself! He watched as ");
        wgwBuilder.append(andy).append(" stroked his ");
        wgwBuilder.append(cockAdjectiveFirst).append(" ").append(cockAdjectiveSecond);
        wgwBuilder.append(" cock. He approached ").append(andy);
        wgwBuilder.append(" which startled him and make him pee everywhere ");
        wgwBuilder.append("on the floor and on ").append(woody).append(" too. ");
        wgwBuilder.append("Being drenched in his urine made him harder than ever! ");
        wgwBuilder.append(woody).append(": \"").append(andy).append(" Senpai! ");
        wgwBuilder.append("I'm alive and I want to be INSIDE OF YOU.\" ");
        wgwBuilder.append(andy).append(": \"Oh ").append(woody).append(" Chan! ");
        wgwBuilder.append("I always knew you were alive! I want to stuff you up ");
        wgwBuilder.append("my ").append(assAdjectiveFirst).append(" ass!\" ");
        wgwBuilder.append(woody).append(" grabbed a bunch of flavored lube and ");
        wgwBuilder.append("rubbed it all over his ").append(bodypart).append(" ");
        wgwBuilder.append(woody).append(": \"Oh my! It's ").append(lubeFlavour);
        wgwBuilder.append(" flavored lube! ");
        // A quick and hacky conversion of lube flavour to title case.
        wgwBuilder.append(Character.toUpperCase(lubeFlavour.toCharArray()[0]));
        wgwBuilder.append(lubeFlavour.substring(1, lubeFlavour.length()));
        wgwBuilder.append(" is my favourite! ").append(woody).append(" then stuffed ");
        wgwBuilder.append("his ").append(bodypart).append(" back and forth into ");
        wgwBuilder.append(andy).append("'s ").append(assAdjectiveSecond);
        wgwBuilder.append(" ass, continuously making a squishy wet noise. ");
        wgwBuilder.append("The other toys also became aroused and they all ");
        wgwBuilder.append("gathered around ").append(woody).append(" and ").append(andy);
        wgwBuilder.append(" and started to urinate all over them, and then they ");
        wgwBuilder.append(" started to masturbate. ").append(andy).append(": \"");
        wgwBuilder.append("Oh my goodness, ").append(woody).append(" Chan! ");
        wgwBuilder.append("You are churning my insides up so well! Your ");
        wgwBuilder.append(bodypart).append(" is stimulating my prostate! OH YES! ");
        wgwBuilder.append("All the other toys became so aroused by this, that ");
        wgwBuilder.append("they could not help themselves anymore! They pushed ");
        wgwBuilder.append(woody).append(" completely inside, and they all went inside. ");
        wgwBuilder.append("All of them wanted to be inside ").append(andy);
        wgwBuilder.append("'s nice round ass. ").append(andy).append(": \"");
        wgwBuilder.append("No wait guys! My ass cannot hold this much! I'm getting ");
        wgwBuilder.append("so full! All the toys went inside of poor squirming ");
        wgwBuilder.append(andy).append(" and pretty much, he was beyond full, and ");
        wgwBuilder.append("died from having his insides completely damaged. The ");
        wgwBuilder.append("mother came inside and found ").append(andy).append(", ");
        wgwBuilder.append("dead with a huge ass hemorrhage on his anus, with a HUGE ");
        wgwBuilder.append("belly full of toys.");
        // Holy fuck, I did it.

        response.setContentType("text/html; charset=utf8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
              "<!DOCTYPE html><html><body>\n"
            + "<title>nonk's homepage (tm)</title>\n"
            + "<h1>Here is your randomly generated WGW:</h1>\n"
            + String.format("<p>%s</p>\n", wgwBuilder.toString())
            + "</body></html>"
        );
    }
}
