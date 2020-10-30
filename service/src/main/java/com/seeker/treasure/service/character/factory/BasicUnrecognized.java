package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

public class BasicUnrecognized extends PlayerCharacter{
  @Inject
  protected BasicUnrecognized(@Assisted String name) {
    super(name);
  }

  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setPlayerClassValue(-1)
      .setName(super.getNameOrWarning())
      .setExperience(
        Statistics.Experience.newBuilder()
          .setLevel(1)
          .build())
      .build();
  }
}
