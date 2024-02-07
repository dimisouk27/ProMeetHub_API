package com.promeethub_api.services;

import java.util.List;

public interface BaseService<Entity, ID> {

    List<Entity> getAll();
    Entity getOne(ID id);
    Entity create(Entity entity);
    Entity update(Entity entity);
    Entity delete(ID id);

}
