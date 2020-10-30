package com.seeker.treasure.server.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.seeker.treasure.server.runner.DefaultServerConfig;
import com.seeker.treasure.server.runner.DefaultServiceProvider;
import com.seeker.treasure.server.runner.GrpcServerPort;
import com.seeker.treasure.server.runner.Server;
import com.seeker.treasure.service.character.BasicCharacterOperationsImpl;
import com.seeker.treasure.service.character.CharacterServicesGrpc;
import com.seeker.treasure.service.character.factory.CharacterFactory;
import com.seeker.treasure.service.character.factory.CharacterProvider;
import com.seeker.treasure.service.character.BasicCharacterOperations;
import com.seeker.treasure.service.character.CharacterServiceGrpc;
import io.grpc.BindableService;

public class ServerConfigModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Server.class).to(DefaultServerConfig.class);
    bind(Integer.class).annotatedWith(GrpcServerPort.class).toInstance(8090);
  }

  @Provides
  @DefaultServiceProvider
  public BindableService getCharacterService(BasicCharacterOperations basicBasicCharacterOperations) {
    return new CharacterServiceGrpc(basicBasicCharacterOperations);
  }

}
