package com.seeker.treasure.service.character.persistence;

import com.google.protobuf.GeneratedMessageV3;
import com.seeker.treasure.model.response.Response;

public interface Persistence<T extends GeneratedMessageV3> {

  Response.BooleanResponse save(T t);

  Response.BooleanResponse remove(String id);

  T getPersistedMessage (String id);
}
