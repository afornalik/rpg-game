package com.seeker.treasure.service.character;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.service.character.factory.CharacterProvider;
import com.seeker.treasure.service.configuration.CharacterFactoryModule;
import com.seeker.treasure.service.configuration.CharacterServiceModule;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BasicCharacterCharacterFactoryTest {

  public static final String EMPTY_CHARACTER_NAME_WARNING = "Insert character name";
  public static final String CHARACTER_NAME = "Fancy character name";
  private CharacterProvider characterProvider;
  private Injector injector = Guice.createInjector(new CharacterFactoryModule(), new CharacterServiceModule());


  @Test
  public void shouldCreateMageCharacter() {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerAvatar playerAvatar =
      Character.PlayerAvatar.newBuilder()
        .setPlayerClass(Character.PlayerClass.MAGE)
        .setName(CHARACTER_NAME)
        .build();
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerAvatar);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(113);
    softAssertions.assertThat(result.getName()).isEqualTo(CHARACTER_NAME);
    softAssertions.assertThat(result.getPlayerClass()).isEqualTo(Character.PlayerClass.MAGE);

    softAssertions.assertThat(result.getExperience().getExperience()).isEqualTo(0);
    softAssertions.assertThat(result.getExperience().getLevel()).isEqualTo(1);

    softAssertions.assertThat(result.getStatistics().getCharisma()).isEqualTo(4);
    softAssertions.assertThat(result.getStatistics().getDexterity()).isEqualTo(4);
    softAssertions.assertThat(result.getStatistics().getEndurance()).isEqualTo(4);
    softAssertions.assertThat(result.getStatistics().getIntelligence()).isEqualTo(9);
    softAssertions.assertThat(result.getStatistics().getStrength()).isEqualTo(4);
    softAssertions.assertThat(result.getStatistics().getHp()).isEqualTo(10);
    softAssertions.assertThat(result.getStatistics().getMana()).isEqualTo(12);

    softAssertions.assertAll();
  }
  @Test
  public void shouldCreateWarriorCharacter() {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerAvatar playerAvatar =
      Character.PlayerAvatar.newBuilder()
        .setPlayerClass(Character.PlayerClass.WARRIOR)
        .setName(CHARACTER_NAME)
        .build();
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerAvatar);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(111);
    softAssertions.assertThat(result.getName()).isEqualTo(CHARACTER_NAME);
    softAssertions.assertThat(result.getPlayerClass()).isEqualTo(Character.PlayerClass.WARRIOR);

    softAssertions.assertThat(result.getExperience().getExperience()).isEqualTo(0);
    softAssertions.assertThat(result.getExperience().getLevel()).isEqualTo(1);

    softAssertions.assertThat(result.getStatistics().getCharisma()).isEqualTo(3);
    softAssertions.assertThat(result.getStatistics().getDexterity()).isEqualTo(6);
    softAssertions.assertThat(result.getStatistics().getEndurance()).isEqualTo(8);
    softAssertions.assertThat(result.getStatistics().getIntelligence()).isEqualTo(4);
    softAssertions.assertThat(result.getStatistics().getStrength()).isEqualTo(8);
    softAssertions.assertThat(result.getStatistics().getHp()).isEqualTo(18);
    softAssertions.assertThat(result.getStatistics().getMana()).isEqualTo(6);

    softAssertions.assertAll();
  }
  @Test
  public void shouldCreateHunterCharacter() {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerAvatar playerAvatar =
      Character.PlayerAvatar.newBuilder()
        .setPlayerClass(Character.PlayerClass.HUNTER)
        .setName(CHARACTER_NAME)
        .build();
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerAvatar);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(112);
    softAssertions.assertThat(result.getName()).isEqualTo(CHARACTER_NAME);
    softAssertions.assertThat(result.getPlayerClass()).isEqualTo(Character.PlayerClass.HUNTER);

    softAssertions.assertThat(result.getExperience().getExperience()).isEqualTo(0);
    softAssertions.assertThat(result.getExperience().getLevel()).isEqualTo(1);

    softAssertions.assertThat(result.getStatistics().getCharisma()).isEqualTo(5);
    softAssertions.assertThat(result.getStatistics().getDexterity()).isEqualTo(8);
    softAssertions.assertThat(result.getStatistics().getEndurance()).isEqualTo(6);
    softAssertions.assertThat(result.getStatistics().getIntelligence()).isEqualTo(3);
    softAssertions.assertThat(result.getStatistics().getStrength()).isEqualTo(6);
    softAssertions.assertThat(result.getStatistics().getHp()).isEqualTo(14);
    softAssertions.assertThat(result.getStatistics().getMana()).isEqualTo(8);

    softAssertions.assertAll();
  }

  @ParameterizedTest
  @ValueSource(ints = {-1,0,1,2})
  public void shouldCreateCharacterWithWarningIfNameIsEmpty(int playerClass) {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerAvatar playerAvatar =
      Character.PlayerAvatar.newBuilder()
        .setPlayerClassValue(playerClass)
        .build();
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerAvatar);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getName()).isEqualTo(EMPTY_CHARACTER_NAME_WARNING);
    softAssertions.assertThat(result.getPlayerClassValue()).isEqualTo(playerClass);

    softAssertions.assertThat(result.getExperience().getExperience()).isEqualTo(0);
    softAssertions.assertThat(result.getExperience().getLevel()).isEqualTo(1);
    softAssertions.assertAll();
  }

  @Test
  public void shouldCreateNoClassCharacter() {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerAvatar playerAvatar =
      Character.PlayerAvatar.newBuilder()
        .setPlayerClassValue(-1)
        .setName(CHARACTER_NAME)
        .build();
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerAvatar);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(0);
    softAssertions.assertThat(result.getName()).isEqualTo(CHARACTER_NAME);
    softAssertions.assertThat(result.getPlayerClass().equals(Character.PlayerClass.UNRECOGNIZED));
    softAssertions.assertThat(result.getExperience().getExperience()).isEqualTo(0);
    softAssertions.assertThat(result.getExperience().getLevel()).isEqualTo(1);

    softAssertions.assertThat(result.getStatistics().getCharisma()).isEqualTo(0);
    softAssertions.assertThat(result.getStatistics().getDexterity()).isEqualTo(0);
    softAssertions.assertThat(result.getStatistics().getEndurance()).isEqualTo(0);
    softAssertions.assertThat(result.getStatistics().getIntelligence()).isEqualTo(0);
    softAssertions.assertThat(result.getStatistics().getStrength()).isEqualTo(0);
    softAssertions.assertThat(result.getStatistics().getHp()).isEqualTo(0);
    softAssertions.assertThat(result.getStatistics().getMana()).isEqualTo(0);

    softAssertions.assertAll();
  }

}