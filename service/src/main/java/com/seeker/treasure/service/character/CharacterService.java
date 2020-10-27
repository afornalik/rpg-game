package com.seeker.treasure.service.character;

import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.service.Service;

public interface CharacterService extends Service {

  Character.PlayerAvatar getCharacterDetailsById(int id);

  Character.PlayerAvatar createCharacterWithType(Character.PlayerClass playerClass);

  boolean removeCharacterById(int id);

  Character.PlayerAvatar levelUp(Character.PlayerAvatar character);
}
