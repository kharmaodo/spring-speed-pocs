package org.slevin.config.server;

import org.slevin.config.resource.HelloWorldResource;

/**
 * Created by jacky on 19/09/15.
 */
public class ServerThread implements Runnable {
    public void run() {
        EmbeddedJetty embeddedJetty = new EmbeddedJetty(EmbeddedJetty.DEFAULT_PORT,new HelloWorldResource());
        try {
            embeddedJetty.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
