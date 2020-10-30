package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;

public class CharacterProvider {

  private final CharacterFactory characterFactory;

  @Inject
  public CharacterProvider(CharacterFactory characterFactory) {
    this.characterFactory = characterFactory;
  }

  public Character.PlayerAvatar factory(Character.PlayerAvatar playerAvatar) {
    switch (playerAvatar.getPlayerClass()) {
      case HUNTER:
        return characterFactory.createHunter(playerAvatar.getName()).getPlayerAvatar();
      case WARRIOR:
        return characterFactory.createWarrior(playerAvatar.getName()).getPlayerAvatar();
      case MAGE:
        return characterFactory.createMage(playerAvatar.getName()).getPlayerAvatar();
      case UNRECOGNIZED:
        return characterFactory.createUnrecognized(playerAvatar.getName()).getPlayerAvatar();
    }
    return Character.PlayerAvatar.newBuilder().build();
  }
}