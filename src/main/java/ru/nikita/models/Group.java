package ru.nikita.models;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Getter
@Setter
@Introspected
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Group extends Entity {

    private Person person;
    private int number;

}
