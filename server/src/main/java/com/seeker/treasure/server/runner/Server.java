package com.seeker.treasure.server.runner;

public interface Server {

  void startGrpcServer();

  boolean isServerUp();

  void terminate();
}
