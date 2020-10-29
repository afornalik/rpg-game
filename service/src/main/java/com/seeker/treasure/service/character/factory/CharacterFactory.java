package com.seeker.treasure.service.character.factory;

public interface CharacterFactory {

  @Mage
  PlayerCharacter createMage();

  @Warrior
  PlayerCharacter createWarrior();

  @Hunter
  PlayerCharacter createHunter();
}
