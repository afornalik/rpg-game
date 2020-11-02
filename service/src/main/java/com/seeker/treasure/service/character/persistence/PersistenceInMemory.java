package com.seeker.treasure.service.character.persistence;

import com.google.common.collect.Lists;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.response.Response;

import java.util.List;
import java.util.Optional;

public class PersistenceInMemory implements Persistence<Character.PlayerAvatar> {

  private final List<Character.PlayerAvatar> avatars = Lists.newArrayList();

  @Override
  public Response.BooleanResponse save(Character.PlayerAvatar playerAvatar) {
    avatars.add(playerAvatar);
    return getBooleanResponse(true, 0, "No error");
  }

  @Override
  public Character.PlayerAvatar getPersistedMessage(String id) {
    return findCharacter(id)
      .orElseGet(() -> Character.PlayerAvatar.newBuilder().setId("-1").build());
  }

  @Override
  public Response.BooleanResponse remove(String id) {
    Optional<Character.PlayerAvatar> optionalPlayerAvatar = findCharacter(id);

    if (optionalPlayerAvatar.isEmpty()){
      return getBooleanResponse(false, 1, "No character with id: "+id);
    }else {
      avatars.remove(optionalPlayerAvatar.get());
      return getBooleanResponse(true, 0, "No error");
    }
  }

  private Optional<Character.PlayerAvatar> findCharacter(String id) {
    return avatars.stream()
      .filter(storedPlayerAvatar -> storedPlayerAvatar.getId().equals(id))
      .findFirst();
  }

  private Response.BooleanResponse getBooleanResponse(boolean isSuccess, int errorCode, String errorMessage) {
    return Response.BooleanResponse.newBuilder()
      .setIsSuccess(isSuccess)
      .setErrorCode(errorCode)
      .setErrorMessage(errorMessage)
      .build();
  }
}
