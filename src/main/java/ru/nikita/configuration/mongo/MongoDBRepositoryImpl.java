package ru.nikita.configuration.mongo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.reactivestreams.client.FindPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import io.micronaut.context.annotation.Value;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.reactivestreams.Publisher;
import ru.nikita.models.Entity;
import ru.nikita.utils.IdGenerator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import static com.mongodb.client.model.Filters.eq;

@Singleton
@RequiredArgsConstructor
public class MongoDBRepositoryImpl<T extends Entity> {
    @Inject
    private MongoClient mongoClient;

    private final Class<T> clazz;
    private String databaseName = "myapp";

    private MongoDatabase getDatabase() {
        return mongoClient.getDatabase(databaseName);
    }

    private MongoCollection<T> getCollection() {
        String collectionName = clazz.getSimpleName();
        collectionName = Character.toLowerCase(collectionName.charAt(0)) + collectionName.substring(1);
        return getDatabase().getCollection(collectionName, clazz);
    }

    public Publisher<InsertOneResult> save(T entity) {
        return getCollection().insertOne(entity);
    }

    public FindPublisher<T> getAll() {
        return getCollection().find();
    }

    public FindPublisher<T> getById(String id) {
        return getCollection().find(eq("_id", id));
    }

    public Publisher<DeleteResult> deleteById(String id) {
        return getCollection().deleteOne(eq("_id", id));
    }
}
