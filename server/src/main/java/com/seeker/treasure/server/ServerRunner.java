package com.seeker.treasure.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.server.configuration.ServerConfigModule;
import com.seeker.treasure.server.runner.Server;

public class ServerRunner {

  public static void main(String[] args) throws InterruptedException {
    Injector injector = Guice.createInjector(new ServerConfigModule());

    Server server = injector.getInstance(Server.class);

    System.out.println(server.isServerUp());
    server.startGrpcServer();
  }
}
