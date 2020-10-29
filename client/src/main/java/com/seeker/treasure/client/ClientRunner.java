package com.seeker.treasure.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.client.configuration.ClientModule;
import com.seeker.treasure.client.request.CharacterCreateRequest;
import com.seeker.treasure.model.player.Character;

public class ClientRunner {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ClientModule());

    CharacterCreateRequest request = injector.getInstance(CharacterCreateRequest.class);
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClassAndName(Character.PlayerClass.HUNTER,"Czesław"));
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClass(Character.PlayerClass.WARRIOR));
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClass(Character.PlayerClass.WARRIOR));
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClassAndName(Character.PlayerClass.WARRIOR,"Stefan"));
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClass(Character.PlayerClass.HUNTER));
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClass(Character.PlayerClass.WARRIOR).getPlayerClass());
    System.out.println("======new========");
    System.out.println(request.createCharacterWithClass(Character.PlayerClass.HUNTER));
    //System.out.println(request.createCharacterWithClass(Character.PlayerClass.MAGE));
  }
}
