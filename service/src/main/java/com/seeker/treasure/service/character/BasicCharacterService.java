package com.seeker.treasure.service.character;

import com.seeker.treasure.model.player.Character;
import io.grpc.ServiceDescriptor;

public class BasicCharacterService implements CharacterService{

  @Override
  public Character.PlayerAvatar getCharacterDetailsById(int id) {
    return null;
  }

  @Override
  public Character.PlayerAvatar createCharacterWithType(Character.PlayerClass playerClass) {
    return null;
  }

  @Override
  public boolean removeCharacterById(int id) {
    return false;
  }

  @Override
  public Character.PlayerAvatar levelUp(Character.PlayerAvatar character) {
    return null;
  }

  @Override
  public ServiceDescriptor getDescriptor() {
    return ServiceDescriptor.newBuilder("BasicCharacterService").build();
  }
}
