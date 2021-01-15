package ru.nikita.services.impl;

import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import ru.nikita.dao.PersonRepository;
import ru.nikita.models.Group;
import ru.nikita.models.Person;
import ru.nikita.services.GroupService;
import ru.nikita.services.PersonService;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final GroupService groupRepository;


    @Override
    public Single<Person> getById(String id) {
        return Single.fromPublisher(personRepository.getById(id));
    }

    @Override
    public Single<Person> save(Person person) {
        return Single.fromPublisher(personRepository.save(person))
                .flatMap(insertOneResult -> groupRepository.save(new Group(person, 20)))
                .flatMap(group -> Single.just(person));
    }
}
