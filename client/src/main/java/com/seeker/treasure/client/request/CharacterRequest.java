package com.seeker.treasure.client.request;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.service.character.CharacterServicesGrpc;
import io.grpc.ManagedChannel;

public class CharacterRequest  {

  private final CharacterServicesGrpc.CharacterServicesBlockingStub blockingStub;

  @Inject
  public CharacterRequest(ManagedChannel channel) {
    blockingStub = CharacterServicesGrpc.newBlockingStub(channel);
  }

  public Character.PlayerAvatar createCharacterWithClass(Character.PlayerClass playerClass){
    return blockingStub.createCharacter(Character.PlayerAvatar.newBuilder().setPlayerClass(playerClass).build());
  }

}
