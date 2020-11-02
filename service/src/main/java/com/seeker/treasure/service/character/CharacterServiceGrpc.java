package com.seeker.treasure.service.character;

import com.google.inject.Inject;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.response.Response;
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
    responseObserver.onNext(basicCharacterOperations.getCharacterDetailsById(request.getId()));
    responseObserver.onCompleted();
  }

  @Override
  public void createCharacter(Character.PlayerAvatar request, StreamObserver<Character.PlayerAvatar> responseObserver) {
    responseObserver.onNext(basicCharacterOperations.createCharacterBaseOn(request));
    responseObserver.onCompleted();
  }

  @Override
  public void removeCharacter(Character.PlayerAvatar request, StreamObserver<Response.BooleanResponse> responseObserver) {
    responseObserver.onNext(basicCharacterOperations.removeCharacterById(request.getId()));
    responseObserver.onCompleted();
  }

  @Override
  public void saveCharacter(Character.PlayerAvatar request, StreamObserver<Response.BooleanResponse> responseObserver) {
    responseObserver.onNext(basicCharacterOperations.saveCharacter(request));
    responseObserver.onCompleted();
  }

  @Override
  public void levelUpCharacter(Character.PlayerAvatar request, StreamObserver<Character.PlayerAvatar> responseObserver) {
    super.levelUpCharacter(request, responseObserver);
  }
}
