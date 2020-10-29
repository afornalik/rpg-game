package com.seeker.treasure.service.character;

import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;
import com.seeker.treasure.service.character.factory.CharacterProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class BasicCharacterOperationsTest {

  private CharacterProvider mockedCharacterProvider = Mockito.mock(CharacterProvider.class);
  private Character.PlayerClass hunter = Character.PlayerClass.HUNTER;

  @Test
  public void shouldServiceCreateHunter() {
    //given
    BasicCharacterOperationsImpl basicCharacterOperationsImpl = new BasicCharacterOperationsImpl(mockedCharacterProvider);
    when(mockedCharacterProvider.factory(hunter)).thenReturn(mockedHunter());
    //when
    Character.PlayerAvatar result = basicCharacterOperationsImpl.createCharacterWithType(hunter);
    //then
    Assertions.assertNotNull(result);
    Assertions.assertEquals(hunter,result.getPlayerClass());
    Assertions.assertEquals(112,result.getId());
  }

  private Character.PlayerAvatar mockedHunter() {
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