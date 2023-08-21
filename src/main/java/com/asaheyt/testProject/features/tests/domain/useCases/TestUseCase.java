package com.asaheyt.testProject.features.tests.domain.useCases;

import com.asaheyt.testProject.features.tests.domain.models.Test;
import com.asaheyt.testProject.features.tests.domain.services.TestService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public record TestUseCase(
  TestService testService
) {
  public Flux<Test> invoke(String name) {
    return testService.test(name);
  }
}
