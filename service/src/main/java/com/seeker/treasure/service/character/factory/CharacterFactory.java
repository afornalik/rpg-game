package com.seeker.treasure.service.character.factory;

public interface CharacterFactory {

  @Mage
  PlayerCharacter createMage(String name);

  @Warrior
  PlayerCharacter createWarrior(String name);

  @Hunter
  PlayerCharacter createHunter(String name);

  @Unrecognized
  PlayerCharacter createUnrecognized(String name);
}
