package com.seeker.treasure.server.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.seeker.treasure.server.runner.DefaultServerConfig;
import com.seeker.treasure.server.runner.DefaultServiceProvider;
import com.seeker.treasure.server.runner.GrpcServerPort;
import com.seeker.treasure.server.runner.Server;
import com.seeker.treasure.service.Service;
import com.seeker.treasure.service.character.CharacterServiceGrpc;
import com.seeker.treasure.service.character.CharacterServicesGrpc;
import io.grpc.ServerServiceDefinition;

public class ServerConfigModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Server.class).to(DefaultServerConfig.class);
    bind(Integer.class).annotatedWith(GrpcServerPort.class).toInstance(8090);
    bind(Service.class).to(CharacterServiceGrpc.class);
    bind(CharacterServicesGrpc.CharacterServicesImplBase.class).to(CharacterServiceGrpc.class);
  }

  @Provides
  @DefaultServiceProvider
  public  ServerServiceDefinition getCharacterService(Service basicCharacterService) {
    return ServerServiceDefinition.builder(basicCharacterService.getDescriptor()).build();
  }
}
