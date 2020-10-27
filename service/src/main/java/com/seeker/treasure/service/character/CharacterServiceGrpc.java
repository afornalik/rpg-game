package com.seeker.treasure.service.character;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import io.grpc.stub.StreamObserver;

public class CharacterServiceGrpc extends com.seeker.treasure.service.character.CharacterServiceAPIGrpc.CharacterServiceAPIImplBase {

  private final CharacterService characterService;

  @Inject
  public CharacterServiceGrpc(CharacterService characterService) {
    this.characterService = characterService;
  }

  @Override
  public void getCharacterInformation(Character.PlayerAvatar request, StreamObserver<Character.PlayerAvatar> responseObserver) {
    super.getCharacterInformation(request, responseObserver);
  }

  @Override
  public void createCharacter(Character.PlayerAvatar request,
                              StreamObserver<Character.PlayerAvatar> responseObserver) {
    responseObserver.onNext(characterService.createCharacterWithType(request.getPlayerClass()));
    responseObserver.onCompleted();
  }

  @Override
  public void removeCharacter(Character.PlayerAvatar request, StreamObserver<Character.PlayerAvatar> responseObserver) {
    super.removeCharacter(request, responseObserver);
  }

  @Override
  public void levelUpCharacter(Character.PlayerAvatar request, StreamObserver<Character.PlayerAvatar> responseObserver) {
    super.levelUpCharacter(request, responseObserver);
  }
}
