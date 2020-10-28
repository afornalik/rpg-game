package com.seeker.treasure.server.runner;

import com.google.inject.Inject;
import com.seeker.treasure.service.character.BasicCharacterService;
import com.seeker.treasure.service.character.CharacterServiceGrpc;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DefaultServerConfig implements Server {

  private final int port;
  private final ServerServiceDefinition serverServiceDefinition;
  private io.grpc.Server server;

  @Inject
  public DefaultServerConfig(@GrpcServerPort int port,@DefaultServiceProvider ServerServiceDefinition serverServiceDefinition) {
    this.port = port;
    this.serverServiceDefinition = serverServiceDefinition;
  }

  @Override
  public void startGrpcServer() {
    server = ServerBuilder.forPort(port).addService(new CharacterServiceGrpc(new BasicCharacterService())).build();
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
