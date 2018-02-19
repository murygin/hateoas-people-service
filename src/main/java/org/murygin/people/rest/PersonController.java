package org.murygin.people.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/persons", produces = "application/hal+json")
public class PersonController {

  @GetMapping
  public ResponseEntity<Resources<PersonResource>> all() {
    final List<PersonResource> collection =
        getPersonList().stream().map(PersonResource::new).collect(Collectors.toList());
    final Resources<PersonResource> resources = new Resources<>(collection);
    final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
    resources.add(new Link(uriString, "self"));
    return ResponseEntity.ok(resources);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonResource> get(@PathVariable final long id) {
    Person p = new Person((long)1,"Donald","Duck");
    return ResponseEntity.ok(new PersonResource(p));
  }

  private List<Person> getPersonList() {
    List<Person> personList = new LinkedList<>();
    personList.add(new Person((long)1,"Donald","Duck"));
    personList.add(new Person((long)2,"Dagobert","Duck"));
    personList.add(new Person((long)3,"Daniel","Duesentrieb"));
    return personList;
  }

}
