package com.seeker.treasure.client.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.seeker.treasure.client.request.CharacterCreateRequest;
import com.seeker.treasure.server.runner.GrpcServerPort;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(GrpcServerAddress.class).toInstance("localhost");
    bind(Integer.class).annotatedWith(GrpcServerPort.class).toInstance(8090);
  }

  @Provides
  public ManagedChannel provideChannel(@GrpcServerPort int port, @GrpcServerAddress String address){
    return ManagedChannelBuilder.forAddress(address,port).usePlaintext().build();
  }

  @Provides
  public CharacterCreateRequest getCharacterRequest(ManagedChannel managedChannel) {
    return new CharacterCreateRequest(managedChannel);
  }
}
