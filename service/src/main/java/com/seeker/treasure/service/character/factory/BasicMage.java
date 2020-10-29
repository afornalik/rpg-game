package com.seeker.treasure.service.character.factory;

import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;

public class BasicMage extends PlayerCharacter {
  @Override
  public Character.PlayerAvatar getPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(113)
      .setPlayerClass(Character.PlayerClass.MAGE)
      .setExperience(
        Statistics.Experience.newBuilder()
          .setExperience(0)
          .setLevel(1)
          .build())
      .setName("Maaaaaaaaage")
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
