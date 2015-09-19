package org.slevin.config;

import org.slevin.config.resource.HelloWorldResource;
import org.slevin.config.server.EmbeddedJetty;
import org.slevin.config.server.ServerThread;

import java.awt.*;

/**
 * Created by jacky on 18/09/15.
 */
public class Main {


    private static EmbeddedJetty embeddedJetty;

    public static void main(String[] args) throws Exception {


        embeddedJetty = new EmbeddedJetty(EmbeddedJetty.DEFAULT_PORT,new HelloWorldResource());

        embeddedJetty.start();
        System.out.println("HELLO HELLO");
        System.out.println("HELLO HELLO");
        System.out.println("HELLO HELLO");
        System.out.println("HELLO HELLO");



        Thread.sleep(200);
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");


        Thread.sleep(200);
        System.out.println("HELLO KOKOKOKOKOKOKOKO");
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");
        System.out.println("HELLO TOTO");

        Thread.sleep(200);
        embeddedJetty.stop();

    }



}
