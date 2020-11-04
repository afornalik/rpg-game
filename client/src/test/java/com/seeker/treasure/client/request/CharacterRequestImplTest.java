package com.seeker.treasure.client.request;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.client.configuration.ClientModule;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.player.Statistics;
import com.seeker.treasure.model.response.Response;
import com.seeker.treasure.service.character.CharacterServicesGrpc;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

class CharacterRequestImplTest {

  public static final String PLAYER_AVATAR_ID = "96f14106-eea8-4399-bacd-cdb2e38022eb";
  public static final String PLAYER_AVATAR_NAME = "Super player";
  private CharacterServicesGrpc.CharacterServicesBlockingStub blockingStubMock =
    Mockito.mock(CharacterServicesGrpc.CharacterServicesBlockingStub.class);

  @Test
  public void shouldReturnCharacterInformation() {
    //given
    getPlayerAvatarMockedInformation();
    CharacterRequest<Character.PlayerAvatar, Response.BooleanResponse> characterRequest = new CharacterRequestImpl(blockingStubMock);
    //when
    Character.PlayerAvatar result = characterRequest.getCharacterInformationFromService(dummyPlayerAvatar());
    //then
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(result.getId()).isEqualTo(PLAYER_AVATAR_ID);
    softAssertions.assertThat(result.getName()).isEqualTo(PLAYER_AVATAR_NAME);
    softAssertions.assertThat(result.getPlayerClass()).isEqualTo(Character.PlayerClass.MAGE);
    softAssertions.assertAll();
  }

  private void getPlayerAvatarMockedInformation() {
    BDDMockito.when(blockingStubMock.getCharacterInformation(dummyPlayerAvatar()))
      .thenReturn(dummyPlayerAvatarInformationResponse());
  }

  private Character.PlayerAvatar dummyPlayerAvatar() {
    return Character.PlayerAvatar.newBuilder()
      .setId(PLAYER_AVATAR_ID)
      .setPlayerClass(Character.PlayerClass.MAGE)
      .setName(PLAYER_AVATAR_NAME)
      .build();
  }

  private Character.PlayerAvatar dummyPlayerAvatarInformationResponse() {
    return Character.PlayerAvatar.newBuilder()
      .setId(PLAYER_AVATAR_ID)
      .setPlayerClass(Character.PlayerClass.MAGE)
      .setExperience(
        Statistics.Experience.newBuilder()
          .setExperience(0)
          .setLevel(1)
          .build())
      .setName(PLAYER_AVATAR_NAME)
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

