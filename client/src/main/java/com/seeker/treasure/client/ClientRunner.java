package com.seeker.treasure.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.client.configuration.ClientModule;
import com.seeker.treasure.client.request.CharacterRequest;
import com.seeker.treasure.model.player.Character;

public class ClientRunner {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ClientModule());

    CharacterRequest request = injector.getInstance(CharacterRequest.class);
    request.createCharacterWithClass(Character.PlayerClass.HUNTER);
  }
}
