package net.srul.as205315.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerLauncher {

    private static final Logger LOG = LoggerFactory.getLogger(ServerLauncher.class);

    private ServerLauncher(final int port) {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);

        server.setConnectors(new Connector[] { connector });

        WebAppContext context = new WebAppContext();
        context.setServer(server);
        context.setContextPath("/");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            LOG.error("", ex);
        } finally {
            server.destroy();
        }
    }

    public static void main(String[] args) {
        new ServerLauncher(8080);
    }
}
