package ru.nikita.controllers;

import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import ru.nikita.models.Person;
import ru.nikita.services.PersonService;

@RequiredArgsConstructor
@Controller("/api/v1/users")
public class PersonController {

    private final PersonService personService;

    @Get("/{personId}")
    public Single<Person> getPersonById(@PathVariable String personId) {
        return personService.getById(personId);
    }

    @Post
    public Single<Person> savePerson(@Body Person person) {
        return personService.save(person);
    }
}
