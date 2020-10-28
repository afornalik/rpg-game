package com.seeker.treasure.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.server.configuration.ServerConfigModule;
import com.seeker.treasure.server.runner.Server;
import com.seeker.treasure.service.configuration.CharacterServiceModule;

public class ServerRunner {

  public static void main(String[] args) throws InterruptedException {
    Injector injector = Guice.createInjector(new CharacterServiceModule(), new ServerConfigModule());

    Server server = injector.getInstance(Server.class);

    System.out.println(server.isServerUp());
    server.startGrpcServer();
  }
}
