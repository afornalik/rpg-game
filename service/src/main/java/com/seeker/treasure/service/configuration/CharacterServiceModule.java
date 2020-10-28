package com.seeker.treasure.service.configuration;

import com.google.inject.AbstractModule;
import com.seeker.treasure.service.Service;
import com.seeker.treasure.service.character.BasicCharacterService;
import com.seeker.treasure.service.character.CharacterService;
import com.seeker.treasure.service.character.CharacterServiceGrpc;

public class CharacterServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(CharacterService.class).to(BasicCharacterService.class);
    bind(Service.class).to(CharacterServiceGrpc.class);
  }
}
