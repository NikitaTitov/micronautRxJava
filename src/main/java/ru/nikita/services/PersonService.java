package ru.nikita.services;

import com.mongodb.client.result.InsertOneResult;
import io.reactivex.Single;
import ru.nikita.models.Person;

public interface PersonService {

    Single<Person> getById(String id);

    Single<Person> save(Person person);
}
