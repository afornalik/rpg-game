package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

import java.util.UUID;

public class BasicMage extends PlayerCharacter {
  @Inject
  public BasicMage(@Assisted String name) {
    super(name);
  }

  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(UUID.randomUUID().toString())
      .setPlayerClass(Character.PlayerClass.MAGE)
      .setExperience(
        Statistics.Experience.newBuilder()
          .setExperience(0)
          .setLevel(1)
          .build())
      .setName(super.getNameOrWarning())
      .setStatistics(
        Statistics.CharacterStatistics.newBuilder()
          .setCharisma(4)
          .setDexterity(4)
          .setEndurance(4)
          .setIntelligence(9)
          .setStrength(4)
          .setHp(10)
          .setMana(12)
          .build())
      .build();
  }
}
