package com.seeker.treasure.service.configuration;

import com.google.inject.AbstractModule;
import com.seeker.treasure.service.character.BasicCharacterOperationsImpl;
import com.seeker.treasure.service.character.BasicCharacterOperations;
import com.seeker.treasure.service.character.CharacterServiceGrpc;
import com.seeker.treasure.service.character.CharacterServicesGrpc;

public class CharacterServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new CharacterFactoryModule());
    bind(BasicCharacterOperations.class).to(BasicCharacterOperationsImpl.class);
    bind(CharacterServicesGrpc.CharacterServicesImplBase.class).to(CharacterServiceGrpc.class);
  }
}
