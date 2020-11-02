package com.seeker.treasure.client;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.seeker.treasure.client.configuration.ClientModule;
import com.seeker.treasure.client.request.CharacterRequestImpl;
import com.seeker.treasure.model.player.Character;
import com.seeker.treasure.model.response.Response;

public class ClientRunner {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ClientModule());

    CharacterRequestImpl request = injector.getInstance(CharacterRequestImpl.class);
    System.out.println("======new========");
    Character.PlayerAvatar playerAvatar =
      request.createCharacter(
        Character.PlayerAvatar.newBuilder()
        .setPlayerClass(Character.PlayerClass.HUNTER)
        .setName("Zed")
        .build());

    System.out.println(playerAvatar);

    System.out.println("=========save=========");
    Response.BooleanResponse response= request.saveCharacter(playerAvatar);

    System.out.println(response);
    System.out.println("=========info=========");
    Character.PlayerAvatar playerAvatar1 = request.getCharacterInformationFromService(playerAvatar);

    System.out.println(playerAvatar1);
    System.out.println("==========remove=====");
    Response.BooleanResponse response1 = request.removeCharacter(playerAvatar);

    System.out.println(response1);

    System.out.println("==========remove=====");
    Response.BooleanResponse response2 = request.removeCharacter(playerAvatar);

    System.out.println(response2);

    System.out.println("=========info=========");
    Character.PlayerAvatar playerAvatar2 = request.getCharacterInformationFromService(playerAvatar);

    System.out.println(playerAvatar2);
  }
}
