package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

import java.util.UUID;

public class BasicHunter extends PlayerCharacter {
  @Inject
  public BasicHunter(@Assisted String name) {
    super(name);
  }

  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(UUID.randomUUID().toString())
      .setPlayerClass(Character.PlayerClass.HUNTER)
      .setExperience(
        Statistics.Experience.newBuilder()
          .setExperience(0)
          .setLevel(1)
          .build())
      .setName(super.getNameOrWarning())
      .setStatistics(
        Statistics.CharacterStatistics.newBuilder()
          .setCharisma(5)
          .setDexterity(8)
          .setEndurance(6)
          .setIntelligence(3)
          .setStrength(6)
          .setHp(14)
          .setMana(8)
          .build())
      .build();
  }
}
