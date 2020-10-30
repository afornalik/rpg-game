package com.seeker.treasure.service.character.factory;

import com.google.inject.assistedinject.Assisted;
import com.seeker.treasure.model.player.Character;

public abstract class PlayerCharacter {

  private final String name;

  protected PlayerCharacter(@Assisted String name) {
    this.name = name;
  }

  public abstract Character.PlayerAvatar getPlayerAvatar();

  public String getNameOrWarning() {
    return name.equals("") ? "Insert character name" : name;
  }
}
