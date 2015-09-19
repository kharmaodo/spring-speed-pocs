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
    private Object resource;
    private Server server;

    //todo use RUNNABLE THREAD

    public EmbeddedJetty(int serverPort, Object resource){
        this.serverPort = serverPort;
        this.resource = resource;
    }

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


    public void start() {

        try {
            server = configureServer(resource);
            server.start();
            System.out.println("Server started at port " + DEFAULT_PORT + " with context handler for /hello");
//            server.join();
            System.out.println("Joining server");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void stop() {
        System.out.println("Stop server");
        try {
            this.server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isStarted(){
        return this.server.isStarted();
    }

    public boolean isStopped(){
        return this.server.isStopped();
    }


}
