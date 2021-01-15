package ru.nikita.dao;

import com.mongodb.client.result.InsertOneResult;
import org.reactivestreams.Publisher;
import ru.nikita.configuration.mongo.MongoDBRepositoryImpl;
import ru.nikita.models.Person;
import ru.nikita.utils.IdGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonRepository extends MongoDBRepositoryImpl<Person> {

    @Inject
    private IdGenerator idGenerator;

    public PersonRepository() {
        super(Person.class);
    }

    @Override
    public Publisher<InsertOneResult> save(Person entity) {
        entity.setId(idGenerator.id());
        return super.save(entity);
    }
}
