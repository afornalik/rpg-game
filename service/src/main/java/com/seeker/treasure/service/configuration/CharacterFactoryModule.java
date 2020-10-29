package com.seeker.treasure.service.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.seeker.treasure.service.character.factory.BasicHunter;
import com.seeker.treasure.service.character.factory.BasicMage;
import com.seeker.treasure.service.character.factory.BasicWarrior;
import com.seeker.treasure.service.character.factory.CharacterFactory;
import com.seeker.treasure.service.character.factory.Hunter;
import com.seeker.treasure.service.character.factory.Mage;
import com.seeker.treasure.service.character.factory.PlayerCharacter;
import com.seeker.treasure.service.character.factory.Warrior;

public class CharacterFactoryModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new FactoryModuleBuilder()
      .implement(PlayerCharacter.class, Warrior.class, BasicWarrior.class)
      .implement(PlayerCharacter.class, Hunter.class, BasicHunter.class)
      .implement(PlayerCharacter.class, Mage.class, BasicMage.class)
      .build(CharacterFactory.class));

  }
}
