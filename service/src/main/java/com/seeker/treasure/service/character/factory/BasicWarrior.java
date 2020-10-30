package com.seeker.treasure.service.character.factory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

public class BasicWarrior extends PlayerCharacter {
  @Inject
  public BasicWarrior(@Assisted String name) {
    super(name);
  }

  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(111)
      .setPlayerClass(Character.PlayerClass.WARRIOR)
      .setExperience(
        Statistics.Experience.newBuilder()
          .setExperience(0)
          .setLevel(1)
          .build())
      .setName(super.getNameOrWarning())
      .setStatistics(
        Statistics.CharacterStatistics.newBuilder()
          .setCharisma(3)
          .setDexterity(6)
          .setEndurance(8)
          .setIntelligence(4)
          .setStrength(8)
          .setHp(18)
          .setMana(6)
          .build())
      .build();
  }
}
