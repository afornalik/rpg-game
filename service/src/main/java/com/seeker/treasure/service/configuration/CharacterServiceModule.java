package com.seeker.treasure.service.configuration;

import com.google.inject.AbstractModule;
import com.seeker.treasure.service.character.BasicCharacterService;
import com.seeker.treasure.service.character.CharacterService;

public class CharacterServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(CharacterService.class).to(BasicCharacterService.class);
  }
}
