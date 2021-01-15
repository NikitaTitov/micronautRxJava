package ru.nikita.models;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Getter
@Setter
@Introspected
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Person extends Entity {

    private String name;
    private int age;

}
