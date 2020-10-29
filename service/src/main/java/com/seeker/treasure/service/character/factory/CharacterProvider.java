package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;

public class CharacterProvider {

  private final CharacterFactory characterFactory;

  @Inject
  public CharacterProvider(CharacterFactory characterFactory) {
    this.characterFactory = characterFactory;
  }

  public Character.PlayerAvatar factory(Character.PlayerClass playerClass) {
    switch (playerClass) {
      case HUNTER:
        return characterFactory.createHunter().getPlayerAvatar();
      case WARRIOR:
        return characterFactory.createWarrior().getPlayerAvatar();
      case MAGE:
        return characterFactory.createMage().getPlayerAvatar();
      default:
        return Character.PlayerAvatar.newBuilder().build();
    }
  }
}