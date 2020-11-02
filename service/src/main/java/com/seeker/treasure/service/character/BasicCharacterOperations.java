package com.seeker.treasure.service.character;

import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.response.Response;

public interface BasicCharacterOperations {

  Character.PlayerAvatar getCharacterDetailsById(String id);

  Character.PlayerAvatar createCharacterBaseOn(Character.PlayerAvatar playerAvatar);

  Response.BooleanResponse removeCharacterById(String id);

  Response.BooleanResponse saveCharacter(Character.PlayerAvatar playerAvatar);

  Character.PlayerAvatar levelUp(Character.PlayerAvatar character);
}
