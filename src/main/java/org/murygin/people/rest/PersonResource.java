package org.murygin.people.rest;


import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class PersonResource extends ResourceSupport {

  private final Person person;

  public PersonResource(final Person person) {
    this.person = person;
    final long id = person.getId();
    add(linkTo(PersonController.class).withRel("people"));
    add(linkTo(methodOn(PersonController.class).get(id)).withSelfRel());
  }

  public Person getPerson() {
    return person;
  }
}
