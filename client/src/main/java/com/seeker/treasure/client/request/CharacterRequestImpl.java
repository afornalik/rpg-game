package com.seeker.treasure.client.request;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.response.Response;
import com.seeker.treasure.service.character.CharacterService;
import com.seeker.treasure.service.character.CharacterServicesGrpc;
import io.grpc.ManagedChannel;
import io.grpc.stub.AbstractBlockingStub;

public class CharacterRequestImpl implements CharacterRequest<Character.PlayerAvatar, Response.BooleanResponse> {

  private final CharacterServicesGrpc.CharacterServicesBlockingStub blockingStub;

  @Inject
  public CharacterRequestImpl(CharacterServicesGrpc.CharacterServicesBlockingStub stub) {
    blockingStub = stub;
  }

  @Override
  public Character.PlayerAvatar getCharacterInformationFromService(Character.PlayerAvatar playerAvatar) {
    return blockingStub.getCharacterInformation(playerAvatar);
  }

  @Override
  public Character.PlayerAvatar createCharacter(Character.PlayerAvatar playerAvatar) {
    return blockingStub.createCharacter(playerAvatar);
  }

  @Override
  public Response.BooleanResponse removeCharacter(Character.PlayerAvatar playerAvatar) {
    return blockingStub.removeCharacter(playerAvatar);
  }

  @Override
  public Character.PlayerAvatar levelUpCharacter(Character.PlayerAvatar playerAvatar) {
    return blockingStub.levelUpCharacter(playerAvatar);
  }

  @Override
  public Response.BooleanResponse saveCharacter(Character.PlayerAvatar playerAvatar) {
    return blockingStub.saveCharacter(playerAvatar);
  }
}
