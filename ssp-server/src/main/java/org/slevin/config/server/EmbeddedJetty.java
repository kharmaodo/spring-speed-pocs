package org.slevin.config.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slevin.config.resource.HelloWorldResource;

/**
 * Created by jacky on 18/09/15.
 */
public class EmbeddedJetty {

    public static final int DEFAULT_PORT = 9090;

    private int serverPort;
    private Server server;

    private Server configureServer(Object resource) {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(resource.getClass().getPackage().getName());
        resourceConfig.register(JacksonFeature.class);
        ServletContainer servletContainer = new ServletContainer(resourceConfig);
        ServletHolder sh = new ServletHolder(servletContainer);
        server = new Server(serverPort);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(sh, "/*");
        server.setHandler(context);
        return server;
    }


    public void start(int serverPort, Object resource) throws Exception {
        this.serverPort = serverPort;
        server = configureServer(resource);
        server.start();
        server.join();
    }

    public void stop() throws Exception {
        this.server.stop();
    }

}
