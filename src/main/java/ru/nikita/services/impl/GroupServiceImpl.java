package ru.nikita.services.impl;

import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import ru.nikita.dao.GroupRepository;
import ru.nikita.models.Group;
import ru.nikita.services.GroupService;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public Single<Group> getById(String id) {
        return Single.fromPublisher(groupRepository.getById(id));
    }

    @Override
    public Single<Group> save(Group group) {
        return Single.fromPublisher(groupRepository.save(group)).map(insertOneResult -> group);
    }
}
