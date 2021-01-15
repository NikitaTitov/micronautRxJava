package ru.nikita.services;

import io.reactivex.Single;
import ru.nikita.models.Group;

import javax.inject.Singleton;

@Singleton
public interface GroupService {

    Single<Group> getById(String id);

    Single<Group> save(Group group);

}
