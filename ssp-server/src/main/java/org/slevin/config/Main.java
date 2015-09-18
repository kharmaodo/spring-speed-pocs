package org.slevin.config;

import org.slevin.config.resource.HelloWorldResource;
import org.slevin.config.server.EmbeddedJetty;

/**
 * Created by jacky on 18/09/15.
 */
public class Main {



    public static void main(String[] args) throws Exception {
        EmbeddedJetty embeddedJetty = new EmbeddedJetty();
        embeddedJetty.start(EmbeddedJetty.DEFAULT_PORT,new HelloWorldResource());
    }



}
