package com.seeker.treasure.service.character;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import io.grpc.BindableService;
import io.grpc.stub.StreamObserver;

public class CharacterServiceGrpc extends CharacterServicesGrpc.CharacterServicesImplBase implements BindableService {

  private final BasicCharacterOperations basicCharacterOperations;

  @Inject
  public CharacterServiceGrpc(BasicCharacterOperations basicCharacterOperations) {
    this.basicCharacterOperations = basicCharacterOperations;
  }

  @Override
  public void getCharacterInformation(Character.PlayerAvatar request, StreamObserver<Character.PlayerAvatar> responseObserver) {
    super.getCharacterInformation(request, responseObserver);
  }

  @Override
  public void createCharacter(Character.PlayerAvatar request,
                              StreamObserver<Character.PlayerAvatar> responseObserver) {
    responseObserver.onNext(basicCharacterOperations.createCharacterBaseOn(request));
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
