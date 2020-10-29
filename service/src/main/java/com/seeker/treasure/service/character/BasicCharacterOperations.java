package com.seeker.treasure.service.character;

import com.seeker.treasure.model.player.Character;

public interface BasicCharacterOperations {

  Character.PlayerAvatar getCharacterDetailsById(int id);

  Character.PlayerAvatar createCharacterWithType(Character.PlayerClass playerClass);

  boolean removeCharacterById(int id);

  Character.PlayerAvatar levelUp(Character.PlayerAvatar character);
}
