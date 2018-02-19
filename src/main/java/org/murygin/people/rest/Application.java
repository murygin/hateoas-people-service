package org.murygin.people.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@Configuration
@EnableHypermediaSupport(type={EnableHypermediaSupport.HypermediaType.HAL})
public class Application {

  public static void main(String args[]) {
    SpringApplication.run(Application.class);
  }
}
