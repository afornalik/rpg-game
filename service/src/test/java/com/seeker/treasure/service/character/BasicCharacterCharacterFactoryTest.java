package com.seeker.treasure.service.character;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.service.character.factory.CharacterProvider;
import com.seeker.treasure.service.configuration.CharacterFactoryModule;
import com.seeker.treasure.service.configuration.CharacterServiceModule;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class BasicCharacterCharacterFactoryTest {

  private CharacterProvider characterProvider;
  private Injector injector = Guice.createInjector(new CharacterFactoryModule(), new CharacterServiceModule());


  @Test
  public void shouldCreateMageCharacter() {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerClass playerClass = Character.PlayerClass.MAGE;
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerClass);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(113);
    softAssertions.assertThat(result.getName()).isEqualTo("Maaaaaaaaage");
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
    Character.PlayerClass playerClass = Character.PlayerClass.WARRIOR;
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerClass);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(111);
    softAssertions.assertThat(result.getName()).isEqualTo("Waaaaarriooor");
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
    Character.PlayerClass playerClass = Character.PlayerClass.HUNTER;
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerClass);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(112);
    softAssertions.assertThat(result.getName()).isEqualTo("Hunttteeeer");
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

  @Test
  public void shouldCreateNoClassCharacter() {
    //given
    characterProvider = injector.getInstance(CharacterProvider.class);
    Character.PlayerClass playerClass = Character.PlayerClass.UNRECOGNIZED;
    //when
    Character.PlayerAvatar result = characterProvider.factory(playerClass);
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result).isNotNull();

    softAssertions.assertThat(result.getId()).isEqualTo(0);
    softAssertions.assertThat(result.getName()).isEqualTo("");
    softAssertions.assertThat(result.getPlayerClass().equals(Character.PlayerClass.UNRECOGNIZED));
    softAssertions.assertThat(result.getExperience().getExperience()).isEqualTo(0);
    softAssertions.assertThat(result.getExperience().getLevel()).isEqualTo(0);

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