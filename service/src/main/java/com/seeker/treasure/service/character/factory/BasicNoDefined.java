package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

import java.util.UUID;

public class BasicNoDefined extends PlayerCharacter{
  @Inject
  protected BasicNoDefined(@Assisted String name) {
    super(name);
  }

  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(UUID.randomUUID().toString())
      .setPlayerClassValue(0)
      .setName(super.getNameOrWarning())
      .setExperience(
        Statistics.Experience.newBuilder()
          .setLevel(1)
          .build())
      .build();
  }
}
