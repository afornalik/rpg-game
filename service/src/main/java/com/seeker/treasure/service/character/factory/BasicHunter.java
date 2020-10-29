package com.seeker.treasure.service.character.factory;

import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

public class BasicHunter extends PlayerCharacter {
  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(112)
      .setPlayerClass(Character.PlayerClass.HUNTER)
      .setExperience(
        Statistics.Experience.newBuilder()
          .setExperience(0)
          .setLevel(1)
          .build())
      .setName("Hunttteeeer")
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
