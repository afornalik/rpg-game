package com.seeker.treasure.client.request;

import com.google.protobuf.GeneratedMessageV3;

public interface CharacterRequest<P,R extends GeneratedMessageV3> {

  P getCharacterInformationFromService (P p);
  P createCharacter (P p);
  R removeCharacter (P p);
  P levelUpCharacter (P p);
  R saveCharacter (P p);
}
