package com.seeker.treasure.server.runner;

import com.google.inject.Inject;
import io.grpc.BindableService;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DefaultServerConfig implements Server {

  private final int port;
  private final BindableService bindableService;
  private io.grpc.Server server;

  @Inject
  public DefaultServerConfig(@GrpcServerPort int port,@DefaultServiceProvider BindableService bindableService) {
    this.port = port;
    this.bindableService = bindableService;
  }

  @Override
  public void startGrpcServer() {
    server = ServerBuilder.forPort(port).addService(bindableService).build();
    tryToStartGrpcServer(server);
  }

  @Override
  public boolean isServerUp() {
    if (server != null) {
      return !server.isTerminated();
    }
    return false;
  }

  @Override
  public void terminate() {
    if (server != null) {
      server.shutdown();
    }
  }

  private void tryToStartGrpcServer(io.grpc.Server server) {
    try {
      server.start();
      server.awaitTermination(10, TimeUnit.HOURS);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
