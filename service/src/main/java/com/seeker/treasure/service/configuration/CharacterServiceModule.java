package com.seeker.treasure.service.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.service.character.BasicCharacterOperationsImpl;
import com.seeker.treasure.service.character.BasicCharacterOperations;
import com.seeker.treasure.service.character.CharacterServiceGrpc;
import com.seeker.treasure.service.character.CharacterServicesGrpc;
import com.seeker.treasure.service.character.persistence.Persistence;
import com.seeker.treasure.service.character.persistence.PersistenceInMemory;

public class CharacterServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new CharacterFactoryModule());
    bind(new TypeLiteral<Persistence<Character.PlayerAvatar>>(){})
      .to(PersistenceInMemory.class);
    bind(BasicCharacterOperations.class)
      .to(BasicCharacterOperationsImpl.class);
    bind(CharacterServicesGrpc.CharacterServicesImplBase.class)
      .to(CharacterServiceGrpc.class);
  }
}
