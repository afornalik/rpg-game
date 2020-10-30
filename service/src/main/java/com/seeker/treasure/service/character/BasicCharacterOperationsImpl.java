package com.seeker.treasure.service.character;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.service.character.factory.CharacterProvider;

public class BasicCharacterOperationsImpl implements BasicCharacterOperations {

  private final CharacterProvider characterProvider;

  @Inject
  public BasicCharacterOperationsImpl(CharacterProvider characterProvider) {
    this.characterProvider = characterProvider;
  }

  @Override
  public Character.PlayerAvatar getCharacterDetailsById(int id) {
    return null;
  }

  @Override
  public Character.PlayerAvatar createCharacterBaseOn(Character.PlayerAvatar playerAvatar) {
    return characterProvider.factory(playerAvatar);
  }

  @Override
  public boolean removeCharacterById(int id) {
    return false;
  }

  @Override
  public Character.PlayerAvatar levelUp(Character.PlayerAvatar character) {
    return null;
  }


}
