package ru.nikita.dao;

import com.mongodb.client.result.InsertOneResult;
import org.reactivestreams.Publisher;
import ru.nikita.configuration.mongo.MongoDBRepositoryImpl;
import ru.nikita.models.Group;
import ru.nikita.utils.IdGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GroupRepository extends MongoDBRepositoryImpl<Group> {

    @Inject
    private IdGenerator idGenerator;

    public GroupRepository() {
        super(Group.class);
    }

    @Override
    public Publisher<InsertOneResult> save(Group entity) {
        entity.setId(idGenerator.id());
        return super.save(entity);
    }
}
