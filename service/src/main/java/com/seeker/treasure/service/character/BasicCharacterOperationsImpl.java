package com.seeker.treasure.service.character;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.response.Response;
import com.seeker.treasure.service.character.factory.CharacterProvider;
import com.seeker.treasure.service.character.persistence.Persistence;

public class BasicCharacterOperationsImpl implements BasicCharacterOperations {

  private final CharacterProvider characterProvider;
  private final Persistence<Character.PlayerAvatar> playerAvatarPersistence;

  @Inject
  public BasicCharacterOperationsImpl(CharacterProvider characterProvider, Persistence<Character.PlayerAvatar> playerAvatarPersistence) {
    this.characterProvider = characterProvider;
    this.playerAvatarPersistence = playerAvatarPersistence;
  }

  @Override
  public Character.PlayerAvatar getCharacterDetailsById(String id) {
    return playerAvatarPersistence.getPersistedMessage(id);
  }

  @Override
  public Character.PlayerAvatar createCharacterBaseOn(Character.PlayerAvatar playerAvatar) {
    return characterProvider.factory(playerAvatar);
  }

  @Override
  public Response.BooleanResponse removeCharacterById(String id) {
    return playerAvatarPersistence.remove(id);
  }

  @Override
  public Response.BooleanResponse saveCharacter(Character.PlayerAvatar playerAvatar) {
    return playerAvatarPersistence.save(playerAvatar);
  }

  @Override
  public Character.PlayerAvatar levelUp(Character.PlayerAvatar character) {
    return null;
  }


}
