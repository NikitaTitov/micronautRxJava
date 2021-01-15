package ru.nikita.controllers.handlers;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpResponseFactory;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import ru.nikita.exceptions.PersonNotFoundException;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {PersonNotFoundException.class, ExceptionHandler.class})
public class ControllersExceptionHandler implements ExceptionHandler<PersonNotFoundException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, PersonNotFoundException exception) {
        return HttpResponseFactory.INSTANCE.status(HttpStatus.NOT_FOUND).body(exception.getLocalizedMessage());
    }
}
